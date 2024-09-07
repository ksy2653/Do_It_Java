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
	static int[] parent,depth;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		parent = new int[N+1];
		depth = new int[N+1];
		visited = new boolean[N+1];
		tree = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N-1;i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			tree[s].add(e);
			tree[e].add(s);
		}
		
		bfs(1);
		
		int M = sc.nextInt();
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
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
		
		while(depth[a] != depth[b]) {
			a = parent[a];
		}
		
		while(a!=b) {
			a = parent[a];
			b = parent[b];
		}
		
		return a;
	}
	
	public static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		
		int count=0;
		int level=1;
		int node_count=1;
		
		while(!queue.isEmpty()) {
			int now_node = queue.poll();
			for(int next:tree[now_node]) {
				if(!visited[next]) {
					visited[next]=true;
					queue.add(next);
					parent[next] = now_node;
					depth[next] = level;
				}
			}
			
			count++;
			
			if(count==node_count) {
				count=0;
				level++;
				node_count = queue.size();
			}
		}
	}
	
}