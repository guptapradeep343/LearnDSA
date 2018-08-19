package ds.graph;

import ds.stack.StackUsingArray;

public class DFSPaths {
	int start;
	boolean[] marked;
	int edgeTo[];
	Graph graph;

	public DFSPaths(Graph graph, int start) {
		this.start = start;
		this.graph = graph;
		edgeTo = new int[graph.getVertexCount()];
		this.marked = new boolean[graph.getVertexCount()];
		traverse(graph, start);
	}

	public void traverse() {
		traverse(graph, start);
	}

	private void traverse(Graph graph, int v) {
		marked[v] = true;
		if (graph.adjecencyVertex(v) != null) {
			for (int w : graph.adjecencyVertex(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					traverse(graph, w);
				}
			}
		}
	}

	public void pathTo(int v) {
		if (hasPathto(v)) {
			StackUsingArray st = new StackUsingArray(10);
			int i = v;
			for (; i != start; i = edgeTo[i]) {
				st.push(i);
			}
			st.push(i);
			st.printStack();
		}
	}

	private boolean hasPathto(int v) {
		return marked[v];
	}

}
