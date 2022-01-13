package Q8_02_Robot_in_a_Grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import CtCILibrary.AssortedMethods;

public class MyAnsQuestion {
	
	private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> resultPath, HashSet<Point> failedPoints) {
		
		if(row <0 || row >= maze.length || col >= maze[0].length || !maze[row][col]) {
			return false;
		}
		if(failedPoints.contains(new Point(row, col))) {
			failedPoints.add(new Point(row, col));
			return false;
		}
		
		if(row == 0 && col == maze[0].length-1) {
			if(maze[row][col]) {
				//resultPath.add(new Point(row, col));
				return true;
			}
			failedPoints.add(new Point(row, col));
			return false;
		}
		
		// first try down path
		boolean result = getPath(maze, row-1, col, resultPath, failedPoints);
		if(result) {
			resultPath.add(new Point(row-1, col));
			return true;
		}
		failedPoints.add(new Point(row-1, col));
		
		//  try right path
		result = getPath(maze, row, col+1, resultPath, failedPoints);
		if(result) {
			resultPath.add(new Point(row, col+1));
			return true;
		}
		failedPoints.add(new Point(row, col+1));
		return false;
	}
	private static ArrayList<Point> getPath(boolean[][] maze) {
		ArrayList<Point> resultPath = new ArrayList<Point>();
		HashSet<Point> failedPoints = new HashSet<Point>();
		getPath(maze, maze.length-1, 0, resultPath, failedPoints);
		//resultPath.add(new Point(row, col));
		return resultPath;
	}
	
	public static void main(String[] args) {
		int size = 20;
		boolean[][] maze = AssortedMethods.randomBooleanMatrix(size, size, 90);
		
		AssortedMethods.printMatrix(maze);
		
		ArrayList<Point> path = getPath(maze);
		if (path != null) {
			System.out.println(path.toString());
		} else {
			System.out.println("No path found.");
		}
	}
}
