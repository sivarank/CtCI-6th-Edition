package Q8_08_Permutations_With_Dups;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MyAnsQuestion {	

	public static ArrayList<String> getPerms(String remainder){
		ArrayList<String> list = new ArrayList<String>();
		if(remainder.isEmpty()) {
			list.add("");
			return list;
		}else {
			HashSet<String> set = new HashSet<String>();
			for(int i=0 ; i<remainder.length(); i++) {
				if(set.contains(remainder.substring(i, i+1))) {
					continue;
				}
				String left = remainder.substring(0, i);
				String right = remainder.substring(i+1);
				String ch = remainder.substring(i, i+1);
				set.add(ch);
				ArrayList<String> partialSol = getPerms(left+right);
				for (String str : partialSol) {
					list.add(ch+str);
				}
			}
			return list;
		}
	}
	
	public static void main(String[] args) {
		String s = "aabbccc";
		ArrayList<String> result = getPerms(s);
		System.out.println("Count: " + result.size());
		for (String r : result) {
			System.out.println(r);
		}
	}

}
