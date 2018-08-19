package ds.graph;

import java.util.LinkedList;

import jdk.nashorn.internal.runtime.arrays.IteratorAction;

public class EWGraph {
	private LinkedList<Edge> [] adjecency;
	private int vertexCount;
	private int edges;

	public int getVertexCount() {
		return vertexCount;
	}

	public Iterable<Edge> getEdges() {
		LinkedList< Edge> edgeList = new LinkedList<>();
		for(int i=0; i<vertexCount; i++){
			if(adjecency[i]!=null){
				for(Edge e: adjecency[i]){
					Integer v= e.either();
					if(v>e.other(v)){
						edgeList.add(e);
					}
				}
			}
		}
		return edgeList;
	}

	EWGraph(int vertexCount){
		this.adjecency = new LinkedList[vertexCount];
		this.vertexCount = vertexCount;
		this.edges = 0;
	}

	public void addEdge(Edge e){
		int v = e.either();
		int w=e.other(v);
		LinkedList<Edge> linkedList = adjecency[v];
		if(linkedList==null){
			linkedList = new LinkedList<>();
			adjecency[v]=linkedList;
		}
		linkedList.add(e);

		LinkedList<Edge> linkedList2 = adjecency[w];
		if(linkedList2==null){
			linkedList2 = new LinkedList<>();
			adjecency[w]=linkedList2;
		}
		linkedList2.add(e);
		edges =edges + 1;
	}
	/*public void removeEdge(Edge e){
		LinkedList<Integer> linkedList = adjecency[v];
		if(linkedList!=null){
			linkedList.remove(w);
		}
		LinkedList<Integer> linkedList2 = adjecency[v];
		if(linkedList2!=null){
			linkedList2.remove(v);
		}
		edges = edges -1;
	}*/

	LinkedList<Edge> adjecencyVertex(int v){
		return adjecency[v];
	}

}
