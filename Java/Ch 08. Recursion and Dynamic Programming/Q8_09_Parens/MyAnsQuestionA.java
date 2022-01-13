package Q8_09_Parens;

import java.util.HashSet;
import java.util.Set;

public class MyAnsQuestionA {

	
	public static void main(String[] args) {
		Set<String> list = generateParens(4);
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println(list.size());
	}

	private static Set<String> generateParens(int i) {
		Set<String> list = new HashSet<String>();
		generateParanthesis(list, 0,0, i, "");
		return list;
	}

	private static void generateParanthesis(Set<String> result, int leftCount, int rightCount, int count, String value) {
		if(rightCount == count) {
			result.add(value);
			return;
		}
		if(leftCount < count) {
			value += "(";
			generateParanthesis(result, leftCount+1, rightCount, count, value);
		}
		
		if(rightCount < leftCount) {
			value += ")";
			generateParanthesis(result, leftCount, rightCount+1, count, value);
		}
	}
}
