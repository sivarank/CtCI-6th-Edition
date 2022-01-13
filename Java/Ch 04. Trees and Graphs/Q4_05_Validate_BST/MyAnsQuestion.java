package Q4_05_Validate_BST;

import CtCILibrary.TreeNode;

public class MyAnsQuestion {
	public static Integer lastPrinted = null;

	// return last visited value in sub tree
	private static int checkBST(TreeNode root, Integer predecessor){
		if(root.left != null){
			predecessor = checkBST(root.left, predecessor);
		}

		// if left subtree is not BST
		if(predecessor == Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		// first visiting node in traversal 
		if(predecessor == null){
			predecessor = root.data;
		}else{
			// compare value
			if(predecessor > root.data){
				return Integer.MIN_VALUE;
			}else if(root.left == null && predecessor == root.data) { // root node and right mode , should not be same value
				return Integer.MIN_VALUE;
			}
			else{
				predecessor = root.data;
			}
		}

		if(root.right != null){
			predecessor = checkBST(root.right, null);
		}
		return predecessor;
	}

	private static boolean checkBST(TreeNode node){
		if(node == null){
			return true;
		}
		return checkBST(node, Integer.MAX_VALUE) != Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		int[] array = {Integer.MIN_VALUE+3, Integer.MAX_VALUE - 3, Integer.MAX_VALUE - 2, Integer.MAX_VALUE-1};
		TreeNode node = TreeNode.createMinimalBST(array);
		node.print();
		//node.left.data = 5;
		//node.left.right.data = 3;
		System.out.println(checkBST(node));

		test();
	}

	public static void test() {
		TreeNode node;
		boolean condition;
		System.out.println("test cases for equals condition.");

		/* Expect true: for left child: node.data <= last_printed.
   2
  / \
 /   \
 2   3
      \
      4
		*/
		int[] array2 = {1, 2, 3, 4};
		node = TreeNode.createMinimalBST(array2);
		node.left.data = 2;
		node.print();
		lastPrinted = null;
		condition = checkBST(node);
		System.out.println("should be true: " + condition);

		/* Expect false: for right child: node.data <= last_printed.
   2
  / \
 /   \
 1   2
      \
      4
		 */
		int[] array3 = {1, 2, 3, 4};
		node = TreeNode.createMinimalBST(array3);
		node.right.data = 2;
		node.print();
		lastPrinted = null;
		condition = checkBST(node);
		System.out.println("should be false: " + condition);
	}
}