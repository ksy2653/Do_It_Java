package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V,E,K;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<Edge>[] list;
	static PriorityQueue<Edge> q;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		distance = new int[V+1];
		visited = new boolean[V+1];
		list = new ArrayList[V+1];
	
		for(int i=1;i<=V;i++) {
			distance[i] = Integer.MAX_VALUE;
			list[i] = new ArrayList<Edge>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[s].add(new Edge(u,v));
		}
		
		distance[K]=0;
		q = new PriorityQueue<Edge>();
		q.add(new Edge(K,0));
		
		while(!q.isEmpty()) {
			Edge current = q.poll();
			int cur_vertex = current.vertex;
			if(visited[cur_vertex])
				continue;
			visited[cur_vertex] = true;
			
			for(Edge temp: list[cur_vertex]) {
				int next = temp.vertex;
				int value = temp.value;
				
				distance[next] = Math.min(distance[next], distance[cur_vertex] + value);
				q.add(new Edge(next,distance[next]));
			}
		}
		
		for(int i=1;i<=V;i++) {
			if(visited[i])
				System.out.println(distance[i]);
			else
				System.out.println("INF");
		}
	}
}

class Edge implements Comparable<Edge>{
	int vertex;
	int value;
	
	public Edge(int vertex, int value) {
		this.vertex = vertex;
		this.value = value;
	}
	
	public int compareTo(Edge e) {
		return this.value - e.value;
	}
}