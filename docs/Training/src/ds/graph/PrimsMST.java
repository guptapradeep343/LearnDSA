package ds.graph;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class PrimsMST {
	boolean marked[];
	MinPQ<Edge> pq;
	ArrayBlockingQueue<Edge> mst;
	EWGraph g;

	public PrimsMST(EWGraph g) {
		this.g=g;
		this.marked = new boolean[g.getVertexCount()];
		pq = new MinPQ<>(g.getVertexCount());
		mst=new ArrayBlockingQueue<>(g.getVertexCount());
		visit(g,0);
		while(!pq.isEmpty()){
			Edge e = pq.delete();
			int v=e.either();
			int w=e.other(v);
			if(marked[v] && marked[w]) continue;
			mst.add(e);
			System.out.print("\t"+e.getWeight());
			if(!marked[v]){
				visit(g, v);
			} else {
				visit(g, w);
			}
		}
	}

	private void visit(EWGraph g, int v) {
		marked[v] = true;
		for(Edge e : g.adjecencyVertex(v)){
			if(!marked[e.other(v)]){
				pq.insert(e);
			}
		}
	}
}
