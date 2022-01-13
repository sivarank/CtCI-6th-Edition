package Q5_03_Flip_Bit_to_Win;

public class MyAnsQuestionD {

	public static int flipBit(int a) {
		if(a == 0 || a == -1){
			return a == 0 ? 1 : 32 ;
		}
		int index1 = -1, index2 = -1;
		int maxLength = 0;
		int index = 0;
		while(a != 0){
			int bit = a % 2;			
			a >>>= 1;

			if(bit == 0){
				if(index2 == -1){
					index2 = index;
				}else{
					// calculate max length
					maxLength = Math.max(index- index1 -1, maxLength);
					index1 = index2;
					index2 = index;
				}
			}
			index++;
		}
		// if there is no single zero 
		if(index2 == -1){
			maxLength = index+1;
		}else{
			maxLength = Math.max(index- index1 -1, maxLength);
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		int[][] cases = {{-1, 32}, {Integer.MAX_VALUE, 32}, {-10, 31}, {0, 1}, 
				{1, 2}, {15, 5}, {1775, 8}};
		for (int[] c : cases) {
			int x = flipBit(c[0]);
			boolean r = (c[1] == x);
			System.out.println(c[0] + ": " + x + ", " + c[1] + " " + r);
		}

	}

}
