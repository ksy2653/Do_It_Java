package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int count=0;
	static boolean visited[];
	static ArrayList<Integer> connected[];

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		connected = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=1;i<=N;i++) {
			connected[i] = new ArrayList<Integer>();
		}
		
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			connected[s].add(e);
			connected[e].add(s);
		}
		
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
		for(int i:connected[v]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
}