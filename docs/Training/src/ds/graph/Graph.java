package ds.graph;

import java.util.LinkedList;

public class Graph {
	private LinkedList<Integer> [] adjecency;
	private int vertexCount;
	private int edges;

	public int getVertexCount() {
		return vertexCount;
	}

	public int getEdges() {
		return edges;
	}

	Graph(int vertexCount){
		this.adjecency = new LinkedList[vertexCount];
		this.vertexCount = vertexCount;
		this.edges = 0;
	}

	public void addEdge(int v, int w){
		LinkedList<Integer> linkedList = adjecency[v];
		if(linkedList==null){
			linkedList = new LinkedList<>();
			adjecency[v]=linkedList;
		}
		linkedList.add(w);

		LinkedList<Integer> linkedList2 = adjecency[w];
		if(linkedList2==null){
			linkedList2 = new LinkedList<>();
			adjecency[w]=linkedList2;
		}
		linkedList2.add(v);
		edges =edges + 1;
	}
	public void removeEdge(int v, int w){
		LinkedList<Integer> linkedList = adjecency[v];
		if(linkedList!=null){
			linkedList.remove(w);
		}
		LinkedList<Integer> linkedList2 = adjecency[v];
		if(linkedList2!=null){
			linkedList2.remove(v);
		}
		edges = edges -1;
	}

	LinkedList<Integer> adjecencyVertex(int v){
		return adjecency[v];
	}

}
