package Q10_10_Rank_from_Stream;

import CtCILibrary.AssortedMethods;

public class MyAnsQuestion {
	private static RankNode1 root = null;
	
	public static void track(int number) {
		if (root == null) {
			root = new RankNode1(number);
		} else {
			root.insert(number);
		}
	}
	
	public static int getRankOfNumber(int number) {
		return root.getRank(number);
	}
	
	public static void main(String[] args) {
		int size = 10;
		//int[] list = AssortedMethods.randomArray(size, -100, 100);
		int[] list = AssortedMethods.randomArray(size, -5, 5);
		for (int i = 0; i < list.length; i++) {
			track(list[i]);
		}
		
		int[] tracker = new int[size];
		for (int i = 0; i < list.length; i++) {
			int v = list[i];
			int rank1 = root.getRank(list[i]);
			tracker[rank1] = v;		
		}
		
		for (int i = 0; i < tracker.length - 1; i++) {
			if (tracker[i] != 0 && tracker[i + 1] != 0) {
				if (tracker[i] > tracker[i + 1]) {
					System.out.println("ERROR at " + i);
				}
			}
		}

		System.out.println("Array: " + AssortedMethods.arrayToString(list));
		System.out.println("Ranks: " + AssortedMethods.arrayToString(tracker));
	}

}
class RankNode1{
	int leftRank;
	int data;
	RankNode1 left = null, right=null;
	public RankNode1(int val) {
		data = val;
		leftRank = 0;
	}
	void insert(int val) {
		if(val == data) {
			leftRank++;
		}else if(val < data) {
			if(left == null) {
				left = new RankNode1(val);
			}else {
				left.insert(val);;
			}
			leftRank++;
		}else {
			if(right == null) {
				right = new RankNode1(val);
			}else {
				right.insert(val);
			}
		}
	}
	
	int getRank(int val) {
		if(val == data) {
			return leftRank;
		}else if(val < data) {
			return left.getRank(val);
		}else {
			// Assumption 'val' always present in tree
			return leftRank + 1 + right.getRank(val);
		}
	}
}
