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
	static int N,M;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		parent = new int[N+1];
		for(int i=0;i<=N;i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<M;i++) {
			int question = sc.nextInt();
			int a = sc.nextInt();
			int b= sc.nextInt();
			
			if(question==0)
				union(a,b);
			else {
				if(checkSame(a,b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
		
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a!=b) {
			parent[b]=a;
		}
	}
	
	public static int find(int a) {
		if(a == parent[a])
			return parent[a];
		else 
			return parent[a] = find(parent[a]);
	}
	
	public static boolean checkSame(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b)
			return true;
		else
			return false;
	}
	
	
}
