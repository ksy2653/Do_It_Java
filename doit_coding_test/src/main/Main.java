package main;

import java.io.BufferedReader;	
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] tree;
	static int[] depth;
	static boolean[] visited;
	static int[][] parent;
	static int kmax;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		depth = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=1;i<=N;i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			tree[s].add(e);
			tree[e].add(s);
		}
		
		int temp=1;
		kmax=0;
		while(temp<=N) {
			temp<<=1;
			kmax++;
		}
		
		parent = new int[kmax+1][N+1];
		
		bfs(1);
		
		for(int k=1;k<=kmax;k++) {
			for(int n=1;n<=N;n++) {
				parent[k][n] = parent[k-1][parent[k-1][n]];
			}
		}
		
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int LCA = excuteLCA(a,b);
			
			System.out.println(LCA);
		}
		
	}
	
	public static int excuteLCA(int a, int b) {
		if(depth[a] < depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		for(int k=kmax;k>=0;k--) {
			if(Math.pow(2, k) <= depth[a] - depth[b]) {
				if(depth[b] <= depth[parent[k][a]]) {
					a = parent[k][a];
				}
			}
		}
		
		for(int k=kmax;k>=0;k--) {
			if(parent[k][a] != parent[k][b]) {
				a = parent[k][a];
				b = parent[k][b];
			}
		}
		
		int LCA = a;
		if(a!=b) {
			LCA = parent[0][LCA];
		}
		
		return LCA;
	}
	
	public static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		
		int level=1;
		int node_size=1;
		int count=0;
		
		while(!queue.isEmpty()) {
			int now_node=queue.poll();
			for(int next:tree[now_node]) {
				if(!visited[next]) {
					visited[next]=true;
					queue.add(next);
					parent[0][next] = now_node;
					depth[next] = level;
				}
			}
			
			count++;
			
			if(count==node_size) {
				count=0;
				node_size = queue.size();
				level++;
			}
		}
	}
	
}