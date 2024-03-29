function myGraph() {
    this.addNode = function (n) {
        if (!findNode(n.id)) {
            nodes.push({"id": n.id, "label": n.label});
            update();
        }
    };

    this.addLink = function (source, target, value) {
        links.push({"source": findNode(source.id), "target": findNode(target.id), "value": value});
        update();
    };

    this.initialize = function() {
        data.edges.forEach(function(d) {
            graph.addNode(d.source);
            graph.addNode(d.target);
            graph.addLink(d.source, d.target, d.value);
        });
    };

    var findNode = function (nodeId) {
        for (var i in nodes) {
            if (nodes[i].id === nodeId) {
                return nodes[i];
            }
        };
    };

    var countSiblingLinks = function(source, target) {
        var count = 0;
        for(var i = 0; i < links.length; ++i){
            if( (links[i].source.id == source.id && links[i].target.id == target.id) || (links[i].source.id == target.id && links[i].target.id == source.id) )
                count++;
        };
        return count;
    };

    var getSiblingLinks = function(source, target) {
        var siblings = [];
        for(var i = 0; i < links.length; ++i){
            if( (links[i].source.id == source.id && links[i].target.id == target.id) || (links[i].source.id == target.id && links[i].target.id == source.id) )
                siblings.push(links[i].value);
        };
        return siblings;
    };

    var w = window.innerWidth - 20,
        h = window.innerHeight,
        middle = w/2;
    var linkDistance = 300;

    var colors = d3.scale.category20();

    var svg = d3.select("body")
        .append("svg:svg")
        .attr("width", w)
        .attr("height", h)
        .style("z-index", -10)
        .attr("id", "svg");

    svg.append('svg:defs').selectAll('marker')
        .data(['end'])
        .enter()
        .append('svg:marker')
        .attr({'id': "arrowhead",
            'viewBox':'0 -5 10 10',
            'refX': 22,
            'refY': 0,
            'orient':'auto',
            'markerWidth': 20,
            'markerHeight': 20,
            'markerUnits': "strokeWidth",
            'xoverflow':'visible'})
        .append('svg:path')
        .attr('d', 'M0,-5L10,0L0,5')
        .attr('fill', '#ccc');

    var force = d3.layout.force();

    var nodes = force.nodes(),
        links = force.links();

    var update = function () {

        var path = svg.selectAll("path.link")
            .data(force.links());

        path.enter().append("svg:path")
            .attr("id", function (d) {
                return d.source.id + "-" + d.value + "-" + d.target.id;
            })
            .attr("class", "link")
            .attr('marker-end','url(#arrowhead)');

        path.exit().remove();

        var pathInvis = svg.selectAll("path.invis")
            .data(force.links());

        pathInvis.enter().append("svg:path")
            .attr("id", function (d) {
                return "invis_" + d.source.id + "-" + d.value + "-" + d.target.id;
            })
            .attr("class", "invis");

        pathInvis.exit().remove();

        var pathLabel = svg.selectAll(".pathLabel")
            .data(force.links());

        pathLabel.enter().append("g").append("svg:text")
            .attr("class", "pathLabel")
            .append("svg:textPath")
            .attr("startOffset", "50%")
            .attr("text-anchor", "middle")
            .attr("xlink:href", function(d) { return "#invis_" + d.source.id + "-" + d.value + "-" + d.target.id; })
            .style("fill", "#cccccc")
            .style("font-size", 10)
            .text(function(d) { return d.value; });

        var node = svg.selectAll("g.node")
            .data(force.nodes());

        var nodeEnter = node.enter().append("g")
            .attr("class", "node")
            .call(force.drag);

        nodeEnter.append("svg:circle")
            .attr("r", 10)
            .attr("id", function (d) {
                return "Node;" + d.id;
            })
            .attr("class", "nodeStrokeClass")
            .attr("fill", "#0db7ed")

        nodeEnter.append("svg:text")
            .attr("class", "textClass")
            .attr("x", 20)
            .attr("y", ".31em")
            .text(function (d) {
                return d.label;
            });

        node.exit().remove();

        function arcPath(leftHand, d) {
            var x1 = leftHand ? d.source.x : d.target.x,
                y1 = leftHand ? d.source.y : d.target.y,
                x2 = leftHand ? d.target.x : d.source.x,
                y2 = leftHand ? d.target.y : d.source.y,
                dx = x2 - x1,
                dy = y2 - y1,
                dr = Math.sqrt(dx * dx + dy * dy),
                drx = dr,
                dry = dr,
                sweep = leftHand ? 0 : 1;
            siblingCount = countSiblingLinks(d.source, d.target)
            xRotation = 0,
                largeArc = 0;

            if (siblingCount > 1) {
                var siblings = getSiblingLinks(d.source, d.target);
                console.log(siblings);
                var arcScale = d3.scale.ordinal()
                    .domain(siblings)
                    .rangePoints([1, siblingCount]);
                drx = drx/(1 + (1/siblingCount) * (arcScale(d.value) - 1));
                dry = dry/(1 + (1/siblingCount) * (arcScale(d.value) - 1));
            }

            return "M" + x1 + "," + y1 + "A" + drx + ", " + dry + " " + xRotation + ", " + largeArc + ", " + sweep + " " + x2 + "," + y2;
        }

        force.on("tick", function(e) {
            var q = d3.geom.quadtree(nodes),
                i = 0,
                n = nodes.length,
                k = .1 * e.alpha;

            while (++i < n) q.visit(collide(nodes[i]));

            node.attr("transform", function (d) {
                return "translate(" + d.x + "," + d.y + ")";
            });

            path.attr("d", function(d) {
                return arcPath(true, d);
            });

            pathInvis.attr("d", function(d) {
                return arcPath(d.source.x < d.target.x, d);
            });
        });

        force
            .charge(-10000)
            .friction(0.5)
            .linkDistance(linkDistance)
            .size([w, h])
            .start();
        keepNodesOnTop();

    }

    update();

    function collide(node) {
        var r = node.radius + 16,
            nx1 = node.x - r,
            nx2 = node.x + r,
            ny1 = node.y - r,
            ny2 = node.y + r;
        return function(quad, x1, y1, x2, y2) {
            if (quad.point && (quad.point !== node)) {
                var x = node.x - quad.point.x,
                    y = node.y - quad.point.y,
                    l = Math.sqrt(x * x + y * y),
                    r = node.radius + quad.point.radius;
                if (l < r) {
                    l = (l - r) / l * .5;
                    node.x -= x *= l;
                    node.y -= y *= l;
                    quad.point.x += x;
                    quad.point.y += y;
                }
            }
            return x1 > nx2 || x2 < nx1 || y1 > ny2 || y2 < ny1;
        };
    }
}

function drawGraph() {
    graph = new myGraph();
    graph.initialize();
}

drawGraph();

function keepNodesOnTop() {
    $(".nodeStrokeClass").each(function( index ) {
        var gNode = this.parentNode;
        gNode.parentNode.appendChild(gNode);
    });
}