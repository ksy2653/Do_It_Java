package extra.Q9372;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int T,N,M;
	static ArrayList<Integer> airplane[];
	static boolean[] visited;
	static int planes;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/extra/Q9372/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			airplane = new ArrayList[N+1];
			visited = new boolean[N+1];
			
			for(int i=1;i<=N;i++) {
				airplane[i] = new ArrayList<>();
			}
			
			for(int i=1;i<=M;i++) {
				st = new StringTokenizer(br.readLine());
				int c1 = Integer.parseInt(st.nextToken());
				int c2 = Integer.parseInt(st.nextToken());
				
				airplane[c1].add(c2);
				airplane[c2].add(c1);
			}
			
			planes=0;
			dfs(1);
			
			System.out.println(planes);
		}
	}
	
	public static void dfs(int n) {
		visited[n] = true;
		for(int i:airplane[n]) {
			if(!visited[i]) {
				planes++;
				dfs(i);
			}
		}
	}

}
