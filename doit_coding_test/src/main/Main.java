package main;

import java.io.BufferedReader;	
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N,deleteNode,result;
	static boolean[] visited;
	static ArrayList<Integer> tree[];

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visited = new boolean[N];
		tree = new ArrayList[N];
		
		for(int i=0;i<N;i++) {
			tree[i] = new ArrayList<>();
		}
		
		int root=0;
		for(int i=0;i<N;i++) {
			int p = sc.nextInt();
			if(p!=-1) {
				tree[p].add(i);
				tree[i].add(p);
			}
			else
				root=i;
		}
		
		deleteNode = sc.nextInt();
		if(deleteNode == root)
			System.out.println(0);
		else {
			dfs(root);
			System.out.println(result);
		}
			
	}
	
	public static void dfs(int n) {
		visited[n] = true;
		int cNode = 0;
		for(int i:tree[n]) {
			if(visited[i] == false && i != deleteNode) {
				cNode++;
				dfs(i);
			}
		}
		
		if(cNode==0)
			result++;
	}
}
