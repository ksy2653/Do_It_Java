package ch08.Q11657;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static long distance[];
	static Edge edges[];

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch08/Q11657/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		edges = new Edge[M+1];
		distance = new long[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(start,end,time);
		}
		
		//Bellman-Ford Algorithm
		distance[1]=0;
		for(int i=1;i<N;i++) { // loop for (N-1) times
			for(int j=0;j<M;j++) {
				Edge edge = edges[j];
				// update when shorter distance exists
				if(distance[edge.start] != Integer.MAX_VALUE 
						&& distance[edge.end] > distance[edge.start] + edge.time) {
					
					distance[edge.end] = distance[edge.start] + edge.time;
				}
			}
		}
		
		boolean mCycle = false;
		for(int i=0;i<M;i++) { // check negative cycle
			Edge edge = edges[i];
			
			if(distance[edge.start] != Integer.MAX_VALUE 
						&& distance[edge.end] > distance[edge.start] + edge.time)
				mCycle = true;
		}
		
		if(!mCycle) {
			for(int i=2;i<=N;i++) {
				if(distance[i] == Integer.MAX_VALUE)
					System.out.println(-1);
				else
					System.out.println(distance[i]);
			}
		}
		else
			System.out.println(-1);
	}

}

class Edge{
	int start,end,time;

	public Edge(int start, int end, int time) {
		this.start = start;
		this.end = end;
		this.time = time;
	}
	
}