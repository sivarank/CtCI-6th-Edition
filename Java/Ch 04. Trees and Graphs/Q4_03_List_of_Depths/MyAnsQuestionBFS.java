package Q4_03_List_of_Depths;

import CtCILibrary.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MyAnsQuestionBFS {

	// Use BFS
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		if(root == null){
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(new TreeNode(Integer.MIN_VALUE)); // add dummy node for each level

		LinkedList<TreeNode> levelList = new LinkedList<TreeNode>();
		while(!queue.isEmpty()){
			TreeNode node = queue.remove();
			// check whether it is dummy node
			if(node.data == Integer.MIN_VALUE){
				result.add(levelList);
				// create new level list
				levelList = new LinkedList<TreeNode>();
				if(!queue.isEmpty()) {
					queue.add(new TreeNode(Integer.MIN_VALUE)); // add dummy node for each level					
				}
			}else{
				levelList.add(new TreeNode(node.data));
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
			}
		}
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

}
