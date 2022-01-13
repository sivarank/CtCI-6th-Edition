package Q4_01_Route_Between_Nodes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import Q4_01_Route_Between_Nodes.Question.State;
public class MyAnsQuestionB {

	public static void main(String a[])
	{
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[3];
		Node end = n[5];
		System.out.println(search(g, start, end));
	}
	
	public static Graph createNewGraph()
	{
		Graph g = new Graph();        
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 1);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		temp[5].addAdjacent(temp[4]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}
	
	public static void oneLevelBFS(Node startNode, HashSet<String> visitedSet, Queue<Node> queue) {
		for(Node n : startNode.getAdjacent()){
			if(n.state == State.Unvisited){
				queue.add(n);
				visitedSet.add(n.getVertex());
			}
		}
	}

	public static boolean checkCommonNodePresent(Graph g, HashSet<String> srcSet, HashSet<String> destSet){
		for(Node n: g.getNodes()){
			if(srcSet.contains(n.getVertex()) && destSet.contains(n.getVertex())){
				return true;
			}
		}
		return false;
	}

	public static boolean search(Graph g, Node start, Node end) {
		for(Node n: g.getNodes()){
			n.state = State.Unvisited;
		}

		HashSet<String> sourceVisit = new HashSet<String>();
		HashSet<String> destVisit = new HashSet<String>();

		Queue<Node> sourceQueue = new LinkedList<Node>();
		sourceQueue.add(start);
		start.state = State.Visiting;
		sourceVisit.add(start.getVertex());
		
		Queue<Node> destQueue = new LinkedList<Node>();
		destQueue.add(end);
		end.state = State.Visiting;
		destVisit.add(end.getVertex());

		
		while(!sourceQueue.isEmpty() || !destQueue.isEmpty()){
			if(!sourceQueue.isEmpty()){
				Node srcNode = sourceQueue.remove();
				srcNode.state = State.Visited;
				sourceVisit.add(srcNode.getVertex());
				oneLevelBFS(srcNode, sourceVisit, sourceQueue); 
			}
			if(!destQueue.isEmpty()){
				Node destNode = destQueue.remove();
				destNode.state = State.Visited;
				destVisit.add(destNode.getVertex());
				oneLevelBFS(destNode, destVisit, destQueue); 
			}

			if(checkCommonNodePresent(g, sourceVisit, destVisit)){
				return true;
			}
		}
		return false;
	}
}
