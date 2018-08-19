package ds.graph;


public class TwoColorable {
	boolean[] marked;
	boolean vertexColor[];
	boolean colorable;
	Graph graph;

	public boolean colorable() {
		return colorable;
	}

	public TwoColorable(Graph graph) {
		this.graph = graph;
		colorable = true;
		this.vertexColor = new boolean[graph.getVertexCount()];
		this.marked = new boolean[graph.getVertexCount()];
		for(int i=0; i<graph.getVertexCount();i++){
			if(colorable){
				traverse(graph, i);
			}
		}
	}

	private void traverse(Graph graph, int v) {
		marked[v] = true;
		if (graph.adjecencyVertex(v) != null) {
			for (int w : graph.adjecencyVertex(v)) {
				if(!colorable) return;
				else if (!marked[w]) {
					vertexColor[w] = !vertexColor[v];
					traverse(graph, w);
				} else if (vertexColor[w] == vertexColor[v]) {
					colorable = false;
				}
			}
		}
	}

}
