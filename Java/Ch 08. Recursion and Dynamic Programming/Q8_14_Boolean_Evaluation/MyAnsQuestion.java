package Q8_14_Boolean_Evaluation;

import java.util.HashMap;

public class MyAnsQuestion {
	public static int count = 0;

	
	public static int countEval(String s, boolean result, HashMap<String, Integer> map) {
		count++;
		// input is empty
		if(s.isEmpty()) {
			return 0;
		}else if(map.containsKey(result+s)) {
			return map.get(result+s);
		}else if("1".equalsIgnoreCase(s)) {
			return result? 1:0;
		}else if("0".equalsIgnoreCase(s)) {
			return result? 0:1;
		}
		
		int resultWays = 0;
		for(int i=1; i< s.length(); i += 2) {
			int totalTrueCount = 0;
			String left = s.substring(0, i);
			String right = s.substring(i+1);
			
			int leftTrue = countEval(left, true, map);
			int leftFalse = countEval(left, false, map);
			int rightTrue = countEval(right, true, map);
			int rightFalse = countEval(right, false, map);
			int allCount = (leftTrue + leftFalse)*(rightTrue + rightFalse);
			if(s.charAt(i) == '&') {
				totalTrueCount += leftTrue*rightTrue;
			}else if(s.charAt(i) == '|') {
				totalTrueCount += leftTrue*rightTrue + leftTrue*rightFalse + leftFalse*rightTrue;
			}else {
				totalTrueCount += leftTrue*rightFalse + leftFalse*rightTrue;
			}
			
			resultWays += result? totalTrueCount : (allCount-totalTrueCount);
		}
		map.put(result+s, resultWays);
		return resultWays; 
	}
	
	public static void main(String[] args) {
		//String expression = "0^0|1&1^1|0|1";
		String expression = "0|1";
		boolean result = true;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		System.out.println(countEval(expression, result, map));
		System.out.println(count);
	}

}
