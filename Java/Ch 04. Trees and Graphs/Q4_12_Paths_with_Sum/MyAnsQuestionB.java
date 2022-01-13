package Q4_12_Paths_with_Sum;
import java.util.HashMap;

import CtCILibrary.TreeNode;

public class MyAnsQuestionB {
	
	public static int countPathsWithSum(TreeNode root, int targetSum) {
		return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
	}
	
	public static int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
		
		if(node == null) {
			return 0;
		}
		int totalPathCount = 0;
		runningSum +=  node.data;
		if(runningSum == targetSum){
			totalPathCount++;
		}
		if(pathCount.containsKey(runningSum - targetSum)){
			totalPathCount += pathCount.get(runningSum - targetSum);
		}

//		if(pathCount.containsKey(runningSum)){
//			pathCount.put(runningSum, pathCount.get(runningSum) +1 );
//		}else{
//			pathCount.put(runningSum, 1);
//		}
		incrementHashTable(pathCount, runningSum, 1);
		totalPathCount += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
		totalPathCount += countPathsWithSum(node.right, targetSum, runningSum, pathCount);

		incrementHashTable(pathCount, runningSum, -1);
		// remove or delete runningSum entry from Hash table
		//Integer val = pathCount.get(runningSum) == 1 ? pathCount.remove(runningSum) : pathCount.put(runningSum, pathCount.get(runningSum) - 1);
		return totalPathCount;
	}

	
	public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
		Integer value = hashTable.containsKey(key) ? hashTable.get(key) : 0;
		if(value+delta == 0) {
			hashTable.remove(key);
		}else {
			hashTable.put(key, value+delta);			
		}
	}
	
	public static void main(String [] args) {
		/*
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);		
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(-8);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);	
		root.right.left.left = new TreeNode(0);	
		System.out.println(countPathsWithSum(root, 0));
		*/
		
		/*TreeNode root = new TreeNode(-7);
		root.left = new TreeNode(-7);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(20);
		root.right.right.left = new TreeNode(0);
		root.right.right.left.left = new TreeNode(-3);
		root.right.right.left.left.right = new TreeNode(2);
		root.right.right.left.left.right.left = new TreeNode(1);
		System.out.println(countPathsWithSum(root, 0));*/
		
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(0);
		root.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		root.right.left.right = new TreeNode(0);
		root.right.right = new TreeNode(0);
		System.out.println(countPathsWithSum(root, 0));
		System.out.println(countPathsWithSum(root, 4));
	}
}

