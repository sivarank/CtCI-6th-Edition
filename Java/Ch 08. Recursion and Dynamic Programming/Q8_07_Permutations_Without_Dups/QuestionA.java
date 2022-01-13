package Q8_07_Permutations_Without_Dups;

import java.util.*;

public class QuestionA {

	public static ArrayList<String> getPerms(String remainder){
		ArrayList<String> list = new ArrayList<String>();
		if(remainder.isEmpty()) {
			list.add("");
			return list;
		}else {
			for(int i=0 ; i<remainder.length(); i++) {
				String left = remainder.substring(0, i);
				String right = remainder.substring(i+1);
				String ch = remainder.substring(i, i+1);
				
				ArrayList<String> partialSol = getPerms(left+right);
				for (String str : partialSol) {
					list.add(ch+str);
				}
			}
			return list;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = getPerms("abcde");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
	}

}
