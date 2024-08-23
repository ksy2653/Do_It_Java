package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<Edge>[] list;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		
		distance = new int[N+1];
		visited = new boolean[N+1];
		list = new ArrayList[N+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<Edge>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[s].add(new Edge(e,v));
		}
		
		st = new StringTokenizer(br.readLine());
		int startIndex = Integer.parseInt(st.nextToken());
		int endIndex = Integer.parseInt(st.nextToken());
		
		int result = dijkstra(startIndex,endIndex);
		bw.write(result+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int dijkstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start,0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge current = pq.poll();
			int c_v = current.vertex;
			
			if(visited[c_v])
				continue;
			visited[c_v] = true;
			
			for(Edge temp:list[c_v]) {
				int next = temp.vertex;
				int value = temp.value;
				
				if(distance[next] > distance[c_v] + value) {
					distance[next] = distance[c_v] + value;
					pq.add(new Edge(next,distance[next]));
				}
			}
		}
		
		return distance[end];
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
		return value - e.value;
	}
}