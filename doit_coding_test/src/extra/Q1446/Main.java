package extra.Q1446;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,D;
	static int[] distance;
	static ArrayList<Node>[] list;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/extra/Q1446/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		distance = new int[10001];
		for(int i=0;i<=10000;i++) {
			distance[i]=i;
		}
		
		list = new ArrayList[10001];
		for(int i=0;i<=10000;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[s].add(new Node(e,v));
		}
		
		dijkstra(0);
		System.out.println(distance[D]);
	}

	public static void dijkstra(int start) {
		if(start>D)
			return;
		if(distance[start+1] > distance[start] + 1) 
			distance[start+1] = distance[start]+1;
		
		for(int i=0;i<list[start].size();i++) {
			Node temp = list[start].get(i);
			int next = temp.node;
			int dist = temp.weight;
			
			if(distance[next] > distance[start] + dist) {
				distance[next] = distance[start] + dist;
			}
		}
		
		dijkstra(start+1);
	}
}

class Node{
	int node;
	int weight;
	
	public Node(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}
}