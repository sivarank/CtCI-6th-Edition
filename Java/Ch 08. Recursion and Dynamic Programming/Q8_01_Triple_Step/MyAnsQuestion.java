package Q8_01_Triple_Step;

import java.util.Arrays;

public class MyAnsQuestion {

	public static int countWays(int n) {
		int[] map = new int[n + 1];
		Arrays.fill(map, 0);
		map[0] = 0;
		map[1] = 1;
		map[2] = 2;
		map[3] = 4;
		
		for(int i =4; i<=n; i++) {
			map[i] = map[i-1] + map[i-2] + map[i-3];
		}
		return map[n];
	}

	
	public static void main(String[] args) {
		int n = 50;
		int ways = countWays(n);
		System.out.println(ways);
	}

}
