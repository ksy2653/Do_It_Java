package extra.Q1922;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] parent;
	static PriorityQueue<Edge> pq;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/extra/Q1922/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		pq = new PriorityQueue<>();
		
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			if(s!=e)
				pq.add(new Edge(s,e,p));
		}
		
		int useEdge=0;
		int result=0;
		while(useEdge<N-1) {
			Edge now = pq.poll();
			if(find(now.start) != find(now.end)) {
				union(now.start,now.end);
				result += now.price;
				useEdge++;
			}
		}
		
		System.out.println(result);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b)
			parent[b]=a;
	}
	
	public static int find(int a) {
		if(a == parent[a])
			return a;
		else
			return parent[a] = find(parent[a]);
	}

}

class Edge implements Comparable<Edge>{
	int start,end,price;

	public Edge(int start, int end, int price) {
		this.start = start;
		this.end = end;
		this.price = price;
	}
	
	public int compareTo(Edge e) {
		return price - e.price;
	}
}