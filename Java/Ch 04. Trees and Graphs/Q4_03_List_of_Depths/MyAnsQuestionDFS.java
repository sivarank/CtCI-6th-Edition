package Q4_03_List_of_Depths;

import CtCILibrary.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MyAnsQuestionDFS {

	private static void treeTraversal(TreeNode root, ArrayList<LinkedList<TreeNode>> result, int level) {
		if(root == null) {
			return;
		}
		// create new list if there is no list available for this level
		if(result.size() == level) {
			result.add(new LinkedList<TreeNode>());
		}
		result.get(level).add(root);
		treeTraversal(root.left, result, level+1);
		treeTraversal(root.right, result, level+1);
	}

	private static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		treeTraversal(root, result, 0);
		return result;
	}
	
	public static void printResult(ArrayList<LinkedList<TreeNode>> result){
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
	

	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		printResult(list);
	}

/*
 *                               1
 *                              2   3
 *                             4 5  6
 *                              
 */

}
