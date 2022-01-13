package Q8_13_Stack_of_Boxes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MyAnsQuestion {	

		
	
	public static void main(String[] args) {
		Box[] boxList = { new Box(6, 4, 4), new Box(8, 6, 2), new Box(5, 3, 3), new Box(7, 8, 3), new Box(4, 2, 2), new Box(9, 7, 3)};
		ArrayList<Box> boxes = new ArrayList<Box>();
		for (Box b : boxList) {
			boxes.add(b);
		}
		
		int height = createStack(boxes);
		System.out.println(height);
	}

	private static int createStack(ArrayList<Box> boxes) {
		
		// sort boxes by hight
		Collections.sort(boxes, new BoxComparator());
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		int maxHeight = 0;
		
		for(int i=0; i<boxes.size(); i++) {
			int hight = createStack(boxes, i, map);
			maxHeight = Math.max(hight, maxHeight);
		}
		return maxHeight;
	}

	private static int createStack(ArrayList<Box> boxes, int baseIndex, HashMap<Integer, Integer> map) {
		if(map.containsKey(baseIndex)) {
			return map.get(baseIndex);
		}
		Box currentBox = boxes.get(baseIndex);
		int maxHeight = 0;
		for(int i= baseIndex+1; i < boxes.size(); i++) {
			if(boxes.get(i).canBeAbove(currentBox)) {
				int height = createStack(boxes, i, map);
				maxHeight = Math.max(height, maxHeight);
			}
		}
		map.put(baseIndex, currentBox.height + maxHeight);
		return currentBox.height + maxHeight;
	}

}
