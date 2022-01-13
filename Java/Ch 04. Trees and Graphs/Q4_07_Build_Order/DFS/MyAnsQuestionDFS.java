package Q4_07_Build_Order.DFS;

import java.util.ArrayList;
import java.util.Stack;

public class MyAnsQuestionDFS {

	/* Build the graph, adding the edge (a, b) if b is dependent on a. 
	 * Assumes a pair is listed in â€œbuild orderâ€? (which is the reverse 
	 * of dependency order). The pair (a, b) in dependencies indicates
	 * that b depends on a and a must be built before a. */
	public static Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		
		for (String[] dependency : dependencies) {
			String first = dependency[0];
			String second = dependency[1];
			graph.addEdge(first, second);
		}
		
		return graph;
	}
	
	private static boolean doDFS(Project project, Stack<Project> stk){
		// tODO: need to check project null?
		// found loop
		if(project.getState() == Project.State.PARTIAL || project.getState() == Project.State.COMPLETE){
			return project.getState() == Project.State.COMPLETE;
		}
		project.setState(Project.State.PARTIAL);
		for(Project childProject : project.getChildren()){
			if(!doDFS(childProject, stk)){
				return false;
			}
		}
		project.setState(Project.State.COMPLETE);
		stk.push(project);
		return true;
	}

	private static Stack<Project> orderProjects(ArrayList<Project> projects) {
		Stack<Project> stk = new Stack<Project>();
		for(Project project : projects){
			// doDFS return false if there is loop
			if(project.getState() == Project.State.BLANK && !doDFS(project, stk)){
				return null;
			}
		}
		return stk;
	}


/*
	case 1) single node --> passed
	case 2) two nodes a->b  
	case 3) two nodes a,b 

	case 4) loop  a-->a, a-->b-->a
	*/
	
	public static String[] convertToStringList(Stack<Project> projects) {
		String[] buildOrder = new String[projects.size()];
		for (int i = 0; i < buildOrder.length; i++) {
			buildOrder[i] = projects.pop().getName();
		}
		return buildOrder;
	}
	
	public static Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}
	
	public static String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
		Stack<Project> buildOrder = findBuildOrder(projects, dependencies);
		if (buildOrder == null) return null;
		String[] buildOrderString = convertToStringList(buildOrder);
		return buildOrderString;
	}
	
	public static void main(String[] args) {
		String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
		String[][] dependencies = {
				{"a", "b"},
				{"b", "c"},
				{"a", "c"},
				{"d", "e"},
				{"b", "d"},
				{"e", "f"},
				{"a", "f"},
				{"h", "i"},
				{"h", "j"},
				{"i", "j"},
				{"g", "j"}};
		String[] buildOrder = buildOrderWrapper(projects, dependencies);
		if (buildOrder == null) {
			System.out.println("Circular Dependency.");
		} else {
			for (String s : buildOrder) {
				System.out.println(s);
			}
		}
	}

}
