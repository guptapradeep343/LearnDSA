package ds.graph;

public class Cycle {
	boolean[] marked;
	Graph graph;
	boolean cycle;

	public Cycle(Graph graph) {
		this.graph = graph;
		this.marked = new boolean[graph.getVertexCount()];
		for (int i = 0; i < graph.getVertexCount(); i++) {
			if (!marked[i]) {
				traverse(graph, i, i);
			}
		}
	}

	public void traverse() {
		traverse(graph, 0, 0);
	}

	private void traverse(Graph graph, int v, int u) {
		marked[v] = true;
		System.out.println(v);
		if (graph.adjecencyVertex(v) != null) {
			for (int w : graph.adjecencyVertex(v)) {
				if (cycle)
					return;
				else if (!marked[w]) {
					traverse(graph, w, v);
				} else if(u!=w){
					cycle = true;
				}
			}
		}
	}


	/*
	 * Will not work
	 *
	 * private void traverse(Graph graph, int v) {
		marked[v] = true;
		System.out.println(v);
		if (graph.adjecencyVertex(v) != null) {
			for (int w : graph.adjecencyVertex(v)) {
				if (cycle)
					return;
				else if (!marked[w]) {
					traverse(graph, w);
				} else {
					cycle = true;
				}
			}
		}
	}*/

	public boolean hasCycle() {
		return cycle;
	}
}
