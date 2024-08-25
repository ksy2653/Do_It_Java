package ch08.Q1219;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M,sCity,eCity;
	static long distance[], cityMoney[];
	static Edge edges[];

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch08/Q1219/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		sCity = Integer.parseInt(st.nextToken());
		eCity = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		edges = new Edge[M];
		distance = new long[N];
		cityMoney = new long[N];
		
		Arrays.fill(distance, Long.MIN_VALUE);
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(start,end,price);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			cityMoney[i] = Long.parseLong(st.nextToken());
		}
		
		// modified Bellman-Ford algorithm
		distance[sCity] = cityMoney[sCity];
		// loop for large enough numbers to find positive cycle
		for(int i=0;i<=N+100;i++) {
			for(int j=0;j<M;j++) {
				int start = edges[j].start;
				int end = edges[j].end;
				int price = edges[j].price;
				
				// skip when start node doesn't visit
				if(distance[start] == Long.MIN_VALUE)
					continue;
				// update end node with max value when start node exists in positive cycle
				else if(distance[start] == Long.MAX_VALUE)
					distance[end] = Long.MAX_VALUE;
				// update new price when finding new route getting more money
				else if(distance[end] < distance[start] + cityMoney[end] - price) {
					distance[end] = distance[start] + cityMoney[end] - price;
					
					// change end node updated after (N-1)loops into positive cycle
					if(i>=N-1)
						distance[end] = Long.MAX_VALUE;
				}
			}
		}
		
		if(distance[eCity] == Long.MIN_VALUE)
			System.out.println("gg");
		else if(distance[eCity] == Long.MAX_VALUE)
			System.out.println("Gee");
		else
			System.out.println(distance[eCity]);
	}

}

class Edge{
	int start,end,price;

	public Edge(int start, int end, int price) {
		this.start = start;
		this.end = end;
		this.price = price;
	}
	
}