package ch08.Q1707;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int K,V,E;
	static ArrayList<Integer> list[];
	static boolean[] visited;
	static int[] check;
	static boolean isEven;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch08/Q1707/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[V+1];
			visited = new boolean[V+1];
			check = new int[V+1];
			isEven=true;
			
			for(int j=1;j<=V;j++) {
				list[j] = new ArrayList<>();
			}
			
			for(int j=0;j<E;j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				list[s].add(e);
				list[e].add(s);
			}
			
			for(int j=1;j<=V;j++) {
				if(isEven)
					dfs(j);
				else
					break;
			}
			
			if(isEven)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	
	public static void dfs(int node) {
		visited[node]=true;
		for(int i:list[node]) {
			if(!visited[i]) {
				check[i] = (check[node] + 1) % 2;
				dfs(i);
			}
			
			else if(check[node] == check[i])
				isEven = false;
		}
	}

}
