package extra.Q24479;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N,M,R;
	static int count=1;
	static boolean[] visited;
	static ArrayList<Integer> list[];
	static int[] order;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/extra/Q24479/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		list = new ArrayList[N+1];
		order = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i=1;i<=N;i++) {
			Collections.sort(list[i]);
		}
		
		dfs(order,list,R);
		
		for(int i=1;i<=N;i++) {
			if(visited[i] == false)
				order[i]=0;
		}
		
		for(int i=1;i<=N;i++) {
			System.out.println(order[i]);
		}
	}
	
	static public void dfs(int[] a, ArrayList<Integer> b[], int c) {
		visited[c] = true;
		a[c] = count;
		
		for(int i:b[c]) {
			if(!visited[i]) {
				count++;
				dfs(a,b,i);
			}
		}
		
	}

}
