package Q10_05_Sparse_Search;

public class MyAns {

	public static int search(String[] strings, String str) {
		if (strings == null || str == null || str.isEmpty()) {
			return -1;
		}
		return search(strings, str, 0, strings.length - 1);
	}
	
	private static int search(String[] strings, String str, int start, int end) {
		if(start > end) {
			return -1;
		}
		
		int mid = (start + end)/2;
		
		//case 1
		
		if(strings[mid].isEmpty()){
			// find nearest non empty location
			int leftEnd = mid-1;
			int rightEnd = mid+1;
			while(leftEnd >=0 || rightEnd<=end){
				if(leftEnd>=0){
					if(!strings[leftEnd].isEmpty()){
						mid = leftEnd;
						break;
					}else{
						leftEnd--;
					}
				}
				if(rightEnd <=end){
					if(!strings[rightEnd].isEmpty()){
						mid = rightEnd;
						break;
					}else{
						rightEnd++;
					}
				}
			}
		}
		// case 1. Assumption case ignore
		if(strings[mid].equalsIgnoreCase(str)) {
			return mid;
		}else if(strings[mid].compareTo(str)<0){ // LEARN: compareTo returns integer
			return search(strings, str, mid+1, end);
		}else{
			return search(strings, str, start, mid-1);
		}
	}

	public static void main(String[] args) {
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(search(stringList, "ac"));
        System.out.println(search(stringList, "eel"));
		//for (String s : stringList) {
		//	String cloned = new String(s);
        //	System.out.println("<" + cloned + "> " + " appears at location " + search(stringList, cloned));
		//}
	}
}
