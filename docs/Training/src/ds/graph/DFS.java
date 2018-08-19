package ds.graph;


public class DFS {
	int start;
	boolean [] marked;
	Graph graph;

	public DFS(Graph graph, int start) {
		this.start = start;
		this.graph = graph;
		this.marked = new boolean[graph.getVertexCount()];
		traverse(graph, start);
	}

	public void traverse() {
		traverse(graph, start);
	}

	private void traverse(Graph graph, int v) {
		marked[v]=true;
		System.out.println(v);
		if(graph.adjecencyVertex(v)!=null){
			for(int w: graph.adjecencyVertex(v)){
				if(!marked[w]){
					traverse(graph, w);
				}
			}
		}
	}
}
