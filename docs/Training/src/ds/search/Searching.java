package ds.search;

import javafx.util.Pair;

public class Searching {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 5, 9, 8,3,2,1};
		int index = recBinarySearch(a, 5);
		System.out.println(index);
		index = peakSearch(a);
		System.out.println(index);
		int[] b = { 3,3,3,3, 5,9,9,9,9,9};
		index = firstOccuranceSearch(b, 3);
		int lastIndex = lastOccurenceSearch(b, 3);
		System.out.println(index);
		System.out.println(lastIndex);
		
		System.out.println("occurance count:" +(lastIndex-index+1));
		int[] c = {-1, 3,3,3,3, 5,5,5,1,5,5, 9,9,9,9,9,0};
		index = findMin(c);
		
		System.out.println(index);
		
		int[] d = {-1, 3,9,0};
		findMaxMin(c);
	}
	private static int lastOccurenceSearch(int[] a, int key) {
		int high = 1; int low=1;
		
		while(a[high]<=key){
			low=high;
			if(high*2<a.length){
				high = high*2;
			}else{
				high=a.length-1;
				break;
			}
		}
		return lastOccurenceSearch(a, low, high,key);
	}
	private static int lastOccurenceSearch(int[] a, int low, int high, int key) {
		if(low>high) return -1;
		int mid = (low+high)>>1;
		if(a[mid]<key || a[mid+1]==key){
			return lastOccurenceSearch(a, mid+1, high, key);
		}else{
			return lastOccurenceSearch(a, low, mid, key);
		}
	}
	private static void findMaxMin(int[] a) {
		Pair<Integer, Integer> maxMinPair = findMaxMin(a,0, a.length-1);
		System.out.println(maxMinPair);
		
	}
	private static Pair<Integer, Integer> findMaxMin(int[] a, int low, int high) {
		if(low==high) return new Pair<Integer, Integer>(a[low], a[low]);
		int mid= (low+high)>>1;
		Pair<Integer, Integer> findMaxMin1 = findMaxMin(a,low, mid);
		Pair<Integer, Integer> findMaxMin2 = findMaxMin(a, mid+1,high);
		return new Pair<Integer, Integer>(min(findMaxMin1.getKey(),findMaxMin2.getKey()), max(findMaxMin1.getValue(),findMaxMin2.getValue()));
	}
	private static Integer max(Integer x, Integer y) {
		return x>y? x:y;
	}
	private static int findMin(int[] a) {
		return findMin(a, 0, a.length-1);
	}
	private static int findMin(int[] a, int low, int high) {
		if(low==high) return a[low];
		int mid= (low+high)>>1;
		return min(findMin(a, low, mid), findMin(a, mid+1, high));
	}
	private static int min(int x, int y) {
		return x>y? y:x;
	}
	private static int firstOccuranceSearch(int[] a, int key) {
		if(a[0]==key) return 0;
		int high=1, low=1;
		while(a[high]<key){
			low=high;
			high=high*2;
			if(high>a.length-1){
				high = a.length-1;
				break;
			}
		}
		return firstOccuranceSearch(a, key, low, high);
	}

	private static int firstOccuranceSearch(int[] a, int key, int low, int high) {
		if(low>high) return -1;
		int mid=(low+high)>>1;
		if(a[mid]==key && a[mid-1]<key){
			return mid;
		} else if(a[mid]>= key){
			return firstOccuranceSearch(a, key, low, mid-1);
		} else{
			return firstOccuranceSearch(a, key, mid+1, high);
		}
	}

	private static int peakSearch(int[] a) {
		int low=0; int high = a.length-1;
		return peakSearch(a, low, high);
	}

	private static int peakSearch(int[] a, int low, int high) {
		if(low==high) return low;
		if(high-low==1) return a[high]> a[low]? high: low;
		int mid=(low+high)>>1;
		if(a[mid]>a[mid+1] && a[mid]>a[mid-1]){
			return mid;
		} else if(a[mid]<a[mid+1] && a[mid]>a[mid-1]){
			return peakSearch(a, mid+1, high);
		}else{
			return peakSearch(a, low, mid-1);
		}
	}

	private static int recBinarySearch(int[] a, int key) {
		int low=0; int high = a.length-1;
		return recBinarySearch(a, key, low, high);
	}
	private static int recBinarySearch(int[] a, int key, int low, int high) {
		if(low>high) return -1;
		int mid = (low+high)>>1;
		if(a[mid]==key){
			return mid;
		} else if(key>a[mid]){
			return recBinarySearch(a, key, mid +1, high);
		}else{
			return recBinarySearch(a, key, low, mid -1);
		}
	}
	private static int binarySearch(int[] a, int key) {
		int low=0; int high = a.length-1;
		while(low<=high){
			int mid = (low+high)>>1;
			if(a[mid]==key){
				return mid;
			} else if(key>a[mid]){
				low=mid +1;
			}else{
				high = mid-1;
			}
		}
		return -1;
	}
}
