package Q4_02_Minimal_Tree;

import CtCILibrary.TreeNode;

public class MyAnsQuestion {	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		TreeNode root = constructTree(array, 0, array.length-1);
		root.print();
	}

	private static TreeNode constructTree(int[] array, int start, int end) {
		if(start > end) {
			return null;
		}
		int mid = (start + end)/2;
		TreeNode root = new TreeNode(array[mid]);
		root.left = constructTree(array, start, mid-1);
		root.right = constructTree(array, mid+1, end);
		return root;
	}

}
