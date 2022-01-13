package Q8_04_Power_Set;

import java.util.ArrayList;

public class MyAnsQuestionA {

	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int size = 1<<set.size();
		for(int i=0; i<size; i++) {
			ArrayList<Integer> resultEntry = new ArrayList<Integer>();
			Integer j = i, index = 0;
			while(j > 0) {
				
				if((j & 1) == 1) {
					resultEntry.add(set.get(index));
				}
				j >>=1;
				index++;
			}
			allsubsets.add(resultEntry);
		}
		return allsubsets;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}
		ArrayList<ArrayList<Integer>> subsets = getSubsets(list);
		System.out.println(subsets.toString());	
	}

}
