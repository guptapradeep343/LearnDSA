package ds.graph;


public class ConnectedComponent {
	boolean[] marked;
	int cId[];
	int componentCount;
	Graph graph;

	public int getComponentCount() {
		return componentCount;
	}

	public ConnectedComponent(Graph graph) {
		this.graph = graph;
		componentCount=0;
		cId = new int[graph.getVertexCount()];
		this.marked = new boolean[graph.getVertexCount()];
		for(int i=0; i<graph.getVertexCount();i++){
			if(!marked[i]){
				traverse(graph, i, componentCount);
				componentCount++;
			}
		}
	}

	private void traverse(Graph graph, int v, int componentCount) {
		marked[v] = true;
		cId[v] = componentCount;
		if (graph.adjecencyVertex(v) != null) {
			for (int w : graph.adjecencyVertex(v)) {
				if (!marked[w]) {
					traverse(graph, w, componentCount);
				}
			}
		}
	}

	public boolean areConnected(int v, int w) {
		return cId[v]==cId[w];
	}

}
