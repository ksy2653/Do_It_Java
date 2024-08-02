package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int K,V,E;
	static ArrayList<Integer> list[];
	static boolean visited[];
	static int check[];
	static boolean isEven;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		for(int j=0;j<K;j++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[V+1];
			visited = new boolean[V+1];
			check = new int[V+1];
			isEven=true;
			
			for(int i=1;i<=V;i++) {
				list[i]=new ArrayList<>();
			}
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				list[s].add(e);
				list[e].add(s);
			}
			
			for(int i=1;i<=V;i++) {
				if(isEven)
					dfs(i);
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
				check[i] = (check[node]+1) % 2;
				dfs(i);
			}
			else if(check[i] == check[node]) {
				isEven=false;
				break;
			}
		}
	}
}
