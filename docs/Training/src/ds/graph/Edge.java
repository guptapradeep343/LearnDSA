package ds.graph;

public class Edge implements Comparable<Edge>{
	Integer v;
	Integer w;
	Integer weight;
	public int either(){
		return this.v;
	}

	public int other(int u){
		if(this.v==u) return w;
		return v;
	}
	public Edge(int v, int w, int weight) {
		this.v=v;
		this.w = w;
		this.weight=weight;
	}

	@Override
	public int compareTo(Edge e) {
		return this.weight.compareTo(e.weight);
	}

	public Integer getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "v="+v+" w="+w+" weight="+weight;
	}
}
