let G = new jsnx.MultiDiGraph()
let degrees

let server = "http://127.0.0.1:8815/summary_graph?"

let summary_graph_data

function submit_keyword(){
    let k = document.getElementById('distance').value
    let keyword = document.getElementById('keyword').value

    console.log("keyword", keyword, "distance", k)
    if(keyword === ""){
        alert("Please type a key word");
        return false
    }
    if(k < 1){
        alert("The distance have to bigger than 1")
        return false;
    }

    let url = server + "keyword=" + keyword + "&k="+ k
    console.log("Submit_keyword()", url)
    d3.json(url).then( data=>{
        console.log("Update data", data)
        summary_graph_data = data
        G = new jsnx.MultiDiGraph(data)
        updateGraph(data)
    });
    return true;
}
