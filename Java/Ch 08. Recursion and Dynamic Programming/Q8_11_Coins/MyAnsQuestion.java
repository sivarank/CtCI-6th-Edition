package Q8_11_Coins;

public class MyAnsQuestion {	
	public static int makeChangeHelper(int total, int[] denoms, int index) {
		if(total <= 0) {
			return total == 0 ? 1 : 0;
		}else {
			int totalCount = 0;
			for(int i = index; i< denoms.length; i++) {
				totalCount += makeChangeHelper(total - denoms[i], denoms, i);
			}
			return totalCount;
		}
	}
	
	public static int makeChange(int amount, int[] denoms) {
		return makeChangeHelper(amount, denoms, 0);
	}
	
	public static void main(String[] args) {
		int[] denoms = {25, 10, 5, 1};
		int ways = makeChange(25, denoms);
		System.out.println(ways);
	}

}