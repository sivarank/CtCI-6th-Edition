package Q4_10_Check_Subtree;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

public class QuestionA {
	
	public static boolean containsTree(TreeNode t1, TreeNode t2) {
		StringBuilder strb1 = new StringBuilder();
		StringBuilder strb2 = new StringBuilder();

		getOrderString(t1, strb1);
		getOrderString(t2, strb2);

		return strb1.indexOf(strb2.toString()) != -1;
	}
	
	public static void getOrderString(TreeNode node, StringBuilder sb) {
		if(node == null){
			sb.append('X');
			return;
		}
		sb.append(((Integer)node.data).toString());
		getOrderString(node.left, sb);
		getOrderString(node.right, sb);
	}

	public static void main(String[] args) {
		// t2 is a subtree of t1
		int[] array1 = {1, 2, 1, 3, 1, 1, 5};
		int[] array2 = {2, 3, 1};
		
		TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
		TreeNode t2 = AssortedMethods.createTreeFromArray(array2);

		if (containsTree(t1, t2)) {
			System.out.println("t2 is a subtree of t1");
		} else {
			System.out.println("t2 is not a subtree of t1");
		}

		// t4 is not a subtree of t3
		int[] array3 = {1, 2, 3};
		TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
		TreeNode t4 = AssortedMethods.createTreeFromArray(array3);

		if (containsTree(t3, t4)) {
			System.out.println("t4 is a subtree of t3");
		} else {
			System.out.println("t4 is not a subtree of t3");
		}
	}

}
