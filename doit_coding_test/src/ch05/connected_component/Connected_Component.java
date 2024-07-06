package ch05.connected_component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// Baekjoon Q11724 
public class Connected_Component {
	static ArrayList<Integer>[] list;
	static boolean visited[];
	static int N,M;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch05/connected_component/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list[s].add(e);
			list[e].add(s);
		}
		
		int count=0;
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				count++;
				dfs(i);
			}
		}
		
		System.out.println(count);

	}
	
	public static void dfs(int v) {
		if(visited[v])
			return;
		visited[v] = true;
		for(int i: list[v]) {
			if(visited[i] == false)
				dfs(i);
		}
	}

}
