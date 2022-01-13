package Q10_03_Search_in_Rotated_Array;

public class MyAns {
	
	public static int search(int a[], int x) {
		return search(a,0,a.length -1, x);
	}

	private static int search(int[] a, int start, int end, int keyValue) {
		if(start > end) {
			return -1;
		}else if(start == end) {
			return a[start] == keyValue ? start : -1;
		}else {
			int mid = (start + end)/2; 
			// find sorted array
			if(a[start] < a[mid]) {
				int result = bSearch(a, start, mid, keyValue);
				if(result != -1) {
					return result;
				}else {
					return search(a,mid+1, end, keyValue);
				}
			}else {
				// second half is sorted array
				int result = bSearch(a, mid+1, end, keyValue);
				if(result != -1) {
					return result;
				}else {
					return search(a,start, mid, keyValue);
				}
			}
		}
	}

	private static int bSearch(int[] a, int start, int end, int keyValue) {
		while(start <= end) {
			int mid =(start + end)/2;
			if(a[mid] == keyValue) {
				return mid;
			}else if(a[mid] < keyValue) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 1, 2, 2, 2, 2, 2 , 2 , 2 };

		System.out.println(search(a, 2));
		System.out.println(search(a, 3));
		System.out.println(search(a, 4));
		System.out.println(search(a, 1));
		System.out.println(search(a, 8));
	}

}
