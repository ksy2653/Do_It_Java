package extra.Q13549;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int start,end;
	static int time[];
	static boolean[] visited;
	static PriorityQueue<Node> pq;
	static int minTime;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		start = sc.nextInt();
		end = sc.nextInt();

		//visited = new boolean[100001];
		time = new int[100001];
		Arrays.fill(time, Integer.MAX_VALUE);
		
		if(start >= end)
			minTime = start - end;
		else {
			dijkstra();
			minTime = time[end];
		}
		
		System.out.println(minTime);
	}
	
	public static void dijkstra() {
		pq = new PriorityQueue<Node>();
		time[start]=0;
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int next = current.node;
			int dist = current.weight;
			
			if(next>0 && time[next-1] > time[next] + 1) {
				time[next-1] = time[next]+1;
				pq.add(new Node(next-1,time[next-1]));
			}
			
			if(next < 100000 && time[next+1] > time[next] + 1) {
				time[next+1] = time[next]+1;
				pq.add(new Node(next+1,time[next+1]));
			}
			
			if(next*2 <= 100000 && time[next*2] > time[next]) {
				time[next*2] = time[next];
				pq.add(new Node(next*2,time[next*2]));
			}
		}
	}

}

class Node implements Comparable<Node>{
	int node;
	int weight;
	
	public Node(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}
	
	public int compareTo(Node n) {
		return weight - n.weight;
	}
}
