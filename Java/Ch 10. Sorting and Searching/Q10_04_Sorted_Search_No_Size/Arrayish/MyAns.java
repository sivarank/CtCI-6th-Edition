package Q10_04_Sorted_Search_No_Size.Arrayish;

public class MyAns {

	public static int binarySearch(Listy list, int value, int low, int high) {
		int mid;
		
		while (low <= high) {
			mid = (low + high) / 2;
			int middle = list.elementAt(mid);
			if (middle > value || middle == -1) {
				high = mid - 1;
			} else if (middle < value) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;		
	}
	
	public static int search(Listy list, int value) {
		int cur = 2;
		int pre = 1;
		if(list.elementAt(0) == value || list.elementAt(1) == value) {
			return list.elementAt(0) == value ? 0 : 1;
		}
		while(true) {
			if(list.elementAt(cur) == -1) {
				cur = (cur + pre)/2;
			}else {
				if(list.elementAt(cur) == value) {
					return cur;
				}else if(list.elementAt(cur) < value) {
					pre = cur;
					cur *=2; 
				}else {
					return binarySearch(list, value, pre, cur);
				}
			}
		}
	}
	public static int search1(Listy list, int value) {
		if(list.elementAt(1) == -1) {
			return value == list.elementAt(0)?0:-1;
		}
		
		int end = 1;
		while(true) {
			if((list.elementAt(end) != -1) && ( list.elementAt(end+1) == -1 ||  list.elementAt(end) > value)) {
				break;
			}else {
				// Not valid element
				if(list.elementAt(end) == -1) {
					end = (end + end/2)/2;
				}else {
					end *=2;
				}
			}
		}
		return binarySearch(list, value, 0, end);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18};
		Listy list = new Listy(array);
		for (int a : array) {
			System.out.println(search1(list, a));
		}
		System.out.println(search1(list, 15));
	}

}
