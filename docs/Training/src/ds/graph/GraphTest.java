package ds.graph;

public class GraphTest {

	public static void main(String[] args) {
		Graph g = new Graph(12);

		g.addEdge(0, 5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 6);
		g.addEdge(5, 4);
		//g.addEdge(5, 3);
		g.addEdge(4, 3);
		g.addEdge(4, 6);
		g.addEdge(7, 8);
		g.addEdge(9, 8);
		g.addEdge(9, 10);

		DFS dfs= new DFS(g, 0);

		DFSPaths dfspath = new DFSPaths(g, 0);

		dfspath.pathTo(5);
		TwoColorable tc = new TwoColorable(g);
		ConnectedComponent cc = new ConnectedComponent(g);
		Cycle cycle = new Cycle(g);

		System.out.println(tc.colorable());
		System.out.println(cycle.hasCycle());
		System.out.println(cc.getComponentCount());
		System.out.println(cc.areConnected(8, 9));

		EWGraph ewg = new EWGraph(8);
		Edge e = new Edge(0, 7, 16);
		ewg.addEdge(e);

		e = new Edge(0, 4, 38);
		ewg.addEdge(e);

		e = new Edge(0, 2, 26);
		ewg.addEdge(e);

		e = new Edge(0, 6, 58);
		ewg.addEdge(e);

		e = new Edge(4, 5, 35);
		ewg.addEdge(e);

		e = new Edge(4, 7, 37);
		ewg.addEdge(e);

		e = new Edge(4, 6, 93);
		ewg.addEdge(e);

		e = new Edge(5, 7, 28);
		ewg.addEdge(e);

		e = new Edge(5, 1, 32);
		ewg.addEdge(e);

		e = new Edge(1, 7, 19);
		ewg.addEdge(e);

		e = new Edge(1, 2, 36);
		ewg.addEdge(e);

		e = new Edge(1, 3, 29);
		ewg.addEdge(e);

		e = new Edge(3, 2, 17);
		ewg.addEdge(e);

		e = new Edge(3, 6, 52);
		ewg.addEdge(e);

		e = new Edge(6, 2, 40);
		ewg.addEdge(e);

		e = new Edge(2, 7, 34);
		ewg.addEdge(e);

		PrimsMST pmst = new PrimsMST(ewg);


	}

}
