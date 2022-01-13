package Q10_03_Search_in_Rotated_Array;

public class MyAns2 {

	private static int search(int a[], int x) {
		return search(a, 0, a.length - 1, x);
	}

	private static int search(int[] a, int start, int end, int key) {
		if(start <0 || end < start) {
			return -1;
		}
		if (start == end) {
			return start >= 0 ? (a[start] == key ? start : -1) : -1;
		}
		int mid = (start + end) / 2;
		if (a[mid] == key) {
			return bSearch(a, start, mid, key);
		}
		if (a[mid] <= a[end]) {
			if (a[mid] < key && key <= a[end]) {
				return bSearch(a, mid + 1, end, key);
			} else {
				return search(a, start, mid - 1, key);
			}
		} else {
			if (a[start] <= key && key < a[mid]) {
				return bSearch(a, start, mid - 1, key);
			} else {
				return search(a, mid + 1, end, key);
			}
		}
	}

	private static int bSearch(int[] a, int start, int end, int key) {
		while (start < end) {
			int mid = (start + end) / 2;
			if (a[mid] == key) {
				if (mid == start)
					return mid;
				end = mid;
			} else if (a[mid] < key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return a[start] == key ? start : -1;
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 1, 2, 2, 2, 2, 2, 2, 2 };

		System.out.println(search(a, 2));
		System.out.println(search(a, 3));
		System.out.println(search(a, 4));
		System.out.println(search(a, 1));
		System.out.println(search(a, 8));
	}

}
