package Q4_04_Check_Balanced;
import CtCILibrary.TreeNode;

public class MyAnsQuestion {
		
	// return Integer.MIN_VALUE if it is not balanced. otherwise height
	private static int getHeight(TreeNode root){
		if(root == null)
		{
			return 0;
		}
		int leftHeight = getHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		int rightHeight = getHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}

		if(Math.abs(leftHeight - rightHeight) > 1){
			return Integer.MIN_VALUE;
		}
		return Math.max(leftHeight, rightHeight)+1;
	}

	/*
					case 1) tree NULL   --  0, passed
					case 2) tree single node --  1, passed
					case 3)  1
	                       2                   -- 2 ,passed
	                       
	                 
	                 - ve 
	                 case 4)    1
	                           2
	                          3

	*/
	
	private static Boolean isBalanced(TreeNode root) {
		return getHeight(root) != Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);

		
		System.out.println("Is balanced? " + isBalanced(root));
		
		root.insertInOrder(4); // Add 4 to make it unbalanced

		System.out.println("Is balanced? " + isBalanced(root));
	}



}
