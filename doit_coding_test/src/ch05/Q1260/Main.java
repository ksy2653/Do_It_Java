package ch05.Q1260;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M,start;
	static boolean visited[];
	static ArrayList<Integer> list[];

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch05/Q1260/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		start = sc.nextInt();
		
		visited = new boolean[N+1];
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=1;i<=M;i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			list[s].add(e);
			list[e].add(s);
		}
		for(int i=1;i<=N;i++) {
			Collections.sort(list[i]);
		}
		
		dfs(start);
		System.out.println();
		visited = new boolean[N+1];
		bfs(start);
	}
	
	public static void dfs(int node) {
		if(visited[node])
			return;
		visited[node] = true;
		System.out.print(node + " ");
		for(int i:list[node]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		
		while(!queue.isEmpty()) {
			int nextNode = queue.poll();
			System.out.print(nextNode + " ");
			for(int i:list[nextNode]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

}
