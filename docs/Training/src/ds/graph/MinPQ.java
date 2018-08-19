package ds.graph;

public class MinPQ<Key extends Comparable<Key>> {
	Comparable<Key>[] keys;
	int totalKeys;
	int capacity;

	public MinPQ(int capacity) {
		this.capacity = capacity;
		this.keys = new Comparable[capacity*capacity];
	}

	public void insert(Key key){
		this.totalKeys++;
		keys[this.totalKeys]=key;
		swim(this.totalKeys);
	}

	public Key delete(){
		Key key = (Key) keys[1];
		keys[1] = keys[totalKeys];
		totalKeys--;
		sink(1);
		return key;
	}

	private void swim(int index) {
		while(index>1 && greater(index/2, index)){
			swap(index/2, index);
			index=index/2;
		}
	}
	private void swap(int i, int j) {
		Comparable<Key> key=keys[j];
		keys[j] = keys[i];
		keys[i] = key;
	}

	private void sink(int index) {
		while(2*index<totalKeys){
			int j= 2*index;
			if(j<totalKeys && greater(j, j+1)){
				j++;
			}
			if(!greater(2*index, j)) break;
			swap(index, j);
			index = j;
		}

	}

	private boolean greater(int i, int j) {
		return keys[i].compareTo((Key) keys[j])>0;
	}

	boolean isEmpty(){
		return totalKeys==0;
	}

}
