let height = 800, width = 1800;
let color = d3.scaleOrdinal(d3.schemeCategory20);
let graph, scaleR;

let links
let nodes

let svg = d3.select("body").append('svg')
    .attr('width', width)
    .attr('height', height);

let simulation = d3.forceSimulation()
    .force("link", d3.forceLink().id(function(d) { return d.id; }))
    .force("charge", d3.forceCollide(20))
    .force("center", d3.forceCenter(width / 2, height / 2));

function updateScale(graph){

    let max = d3.max(graph.nodes, d =>d.degree);
    let min = d3.min(graph.nodes, d => d.degree);

    console.log('min:', min, 'max', max);
    scaleR = d3.scaleLinear().range([5,25])
        .domain([min, max])
}


function updateGraph(graph) {
    dataset = graph;
    updateScale(graph);
    links = svg.selectAll("line.link").data(graph.links, d => d.label)
    links.enter().append('line')
        .attr('id', d=>d.label)
        .attr('class', 'link')
        .attr('fill', 'blue')
        .attr('marker-end', 'url(#arrowhead)')
        .merge(links)

    links.exit()
        .transition()
        .duration(300)
        .attr("stroke-width", 0)
        .remove();


    nodes = svg.selectAll('path.node').data(graph.nodes, d => d.id)
    let nodeEnter = nodes.enter()
    nodes.exit()
        .transition().duration(500)
        .attr("r", 0)
        .attr("fill", function(d) { return color(d.group); })
        .remove();



    nodes = nodes.enter()
        .append("circle")
        .attr('r', d=> {
            console.log(d)
            return scaleR(d.degree)
        })
        .attr("fill", function(d) { return color(d.group); })
        .on('click', (d) => {
            console.log(d);
            d3.json('data/' + d.file)
                .then(
                    updateGraph
                )
        }).call(d3.drag()
            .on("start", dragstarted)
            .on("drag", dragged)
            .on("end", dragended))
        .merge(nodes);

    nodes.transition()
        .duration(1000)
        .attr('r', d=>scaleR(d.degree));


    nodes.append("title")
        .text(function(d) { return d.id; });

    simulation
        .nodes(graph.nodes)
        .on("tick", ticked);

    simulation.force("link")
        .links(graph.links);


    simulation.alphaTarget(0.1).restart();
}



function dragstarted(d) {
    if (!d3.event.active) simulation.alphaTarget(0.1).restart();
    d.fx = d.x;
    d.fy = d.y;
}

function dragged(d) {
    d.fx = d3.event.x;
    d.fy = d3.event.y;
}

function dragended(d) {
    if (!d3.event.active) simulation.alphaTarget(0);
    d.fx = null;
    d.fy = null;
}


function ticked() {
    links
        .attr("x1", function(d) { return d.source.x; })
        .attr("y1", function(d) { return d.source.y; })
        .attr("x2", function(d) { return d.target.x; })
        .attr("y2", function(d) { return d.target.y; });

    nodes
        .attr("cx", function(d) { return d.x; })
        .attr("cy", function(d) { return d.y; });
}


d3.select('#back').on('click', function(){
    d3.json('data/total_G.json').then(
        data => {
            updateGraph(data)
        })
});



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
    }
}
