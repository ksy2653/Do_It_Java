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
	static int N,M;
	static int[] parent;
	static PriorityQueue<Edge> pq;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		parent = new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}
		
		pq = new PriorityQueue<>();
		for(int i=0;i<M;i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int v = sc.nextInt();
			
			pq.add(new Edge(s,e,v));
		}
		
		int result=0;
		for(int i=0;i<N-1;i++) {
			Edge now = pq.poll();
			if(find(now.start) != find(now.end)) {
				union(now.start, now.end);
				result += now.weight;
			}
		}
		
		System.out.println(result);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a!=b)
			parent[b] = a;
	}
	
	public static int find(int a) {
		if(a==parent[a])
			return a;
		else
			return parent[a] = find(parent[a]);
	}
}

class Edge implements Comparable<Edge>{
	int start,end,weight;

	public Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	public int compareTo(Edge e) {
		return weight - e.weight;
	}
	
}