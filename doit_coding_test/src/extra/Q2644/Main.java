package extra.Q2644;

import java.util.*;
import java.io.*;

public class Main {
	static int chon_child,chon_parent;
	static ArrayList<Integer>[] chon;
	static boolean[] visited;
	static int[] chonsoo;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/extra/Q2644/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		chon_parent = Integer.parseInt(st.nextToken());
		chon_child = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		chonsoo = new int[N+1];

		int M = Integer.parseInt(br.readLine());
		chon = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			chon[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int child = Integer.parseInt(st.nextToken());
			int parent = Integer.parseInt(st.nextToken());
			
			chon[child].add(parent);
			chon[parent].add(child);
		}
		
		//chonsoo[chon_child]=0;
		dfs(chon_child);
		
		if(chonsoo[chon_parent]!=0)
			System.out.println(chonsoo[chon_parent]);
		else
			System.out.println(-1);
	}
	
	public static void dfs(int child) {
		for(int next:chon[child]) {
			if(!visited[next]) {
				visited[next]=true;
				chonsoo[next]=chonsoo[child]+1;
				dfs(next);
			}
		}
		
	}

}
