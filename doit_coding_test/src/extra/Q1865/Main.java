package extra.Q1865;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int T,N,M,W;
	static int[] distance;
	static ArrayList<Edge> edges;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/extra/Q1865/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			distance = new int[N+1];
			edges = new ArrayList<Edge>();
			
			//Arrays.fill(distance, Integer.MAX_VALUE);
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				
				edges.add(new Edge(start,end,time));
				edges.add(new Edge(end,start,time));
			}
			
			for(int i=0;i<W;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				
				edges.add(new Edge(start,end,-time));
			}
			
			distance[1]=0;
			for(int i=1;i<N;i++) {
				for(int j=0;j<edges.size();j++) {
					Edge edge = edges.get(j);
					int start = edge.start;
					int end = edge.end;
					int time = edge.time;
					
					if(distance[end] > distance[start] + time)
						distance[end] = distance[start] + time;
				}
			}
			
			boolean isNCycle = false;
			for(int i=0;i<edges.size();i++) {
				Edge edge = edges.get(i);
				int start = edge.start;
				int end = edge.end;
				int time = edge.time;
				
				if(distance[end] > distance[start] + time)
					isNCycle = true;
			}
			
			if(isNCycle)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
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
