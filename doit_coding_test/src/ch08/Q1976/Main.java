package ch08.Q1976;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int[] parent;
	static int[][] city;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch08/Q1976/input.txt"));

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		parent = new int[N+1];
		for(int i=0;i<=N;i++) {
			parent[i]=i;
		}
		
		city = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				city[i][j] = sc.nextInt();
				if(i!=j && city[i][j] == 1)
					union(i,j);
			}
		}
		
		int route = 1;
		int first = sc.nextInt();
		boolean isSame = true;
		while(route<M) {
			int next = sc.nextInt();
			if(find(first) != find(next)) {
				isSame = false;
				break;
			}
			
			route++;
		}
		
		if(isSame)
			System.out.println("YES");
		else
			System.out.println("NO");
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
