package Q4_01_Route_Between_Nodes;

import java.util.LinkedList;
import java.util.Queue;

import Q4_01_Route_Between_Nodes.Question.State;

/**
 * Learinging Bidirectional search
 * @author SIVAR1
 *
 */
public class MyAnsQuestion {

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
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}

	// use BFS
	public static boolean search(Graph g,Node start,Node end) { 
		Queue<Node> q = new LinkedList<Node>();

		for(Node n: g.getNodes()){
			n.state = State.Unvisited;
		}

		// add source node  to queue
		start.state = State.Visiting;
		q.add(start);

		//visit all noides from source.
		// return true if we encounter destination node"end". check for end node while adding nodes to queue

		while(!q.isEmpty()){
			Node node = q.remove();
			for(Node n : node.getAdjacent()){
				if(n.state == State.Unvisited){
					if(n == end){
						return true;
					}
					n.state = State.Visiting;
					q.add(n);			
				}
			}
			node.state = State.Visited;
		}
		return false;
	}
}
