package ch08.Q1043;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static int[] parent;
	public static int[] trueP;
	public static ArrayList<Integer>[] party;
	public static int result;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch08/Q1043/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		result=0;
		
		parent = new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}
		
		trueP = new int[K];
		for(int i=0;i<K;i++) {
			trueP[i] = sc.nextInt();
		}
		
		party = new ArrayList[M];
		for(int i=0;i<M;i++) {
			party[i] = new ArrayList<>();
			int party_size = sc.nextInt();
			for(int j=0;j<party_size;j++) {
				party[i].add(sc.nextInt());
			}
		}
		
		for(int i=0;i<M;i++) {
			int first = party[i].get(0);
			for(int j=1;j<party[i].size();j++) {
				union(first,party[i].get(j));
			}
		}
		
		for(int i=0;i<M;i++) {
			boolean canLie = true;
			int cur = party[i].get(0);
			for(int j=0;j<K;j++) {
				if(find(cur) == find(trueP[j])) {
					canLie = false;
					break;
				}
			}
			
			if(canLie)
				result++;
		}
		
		System.out.println(result);
		
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a!=b)
			parent[b]=a;
	}
	
	public static int find(int a) {
		if(a == parent[a])
			return a;
		else
			return parent[a] = find(parent[a]);
	}

}
