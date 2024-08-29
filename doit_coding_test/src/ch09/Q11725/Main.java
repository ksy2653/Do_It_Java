package ch09.Q11725;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static boolean[] visited;
	static ArrayList<Integer> tree[];
	static int answer[];

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch09/Q11725/input.txt"));

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		visited = new boolean[N+1];
		tree = new ArrayList[N+1];
		answer = new int[N+1];
		
		for(int i=0;i<tree.length;i++) {
			tree[i] = new ArrayList<>();
		}
		for(int i=1;i<N;i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			
			tree[n1].add(n2);
			tree[n2].add(n1);
		}
		
		dfs(1);
		
		for(int i=2;i<=N;i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static void dfs(int number) {
		visited[number] = true;
		for(int i: tree[number]) {
			if(!visited[i]) {
				answer[i] = number;
				dfs(i);
			}
		}
	}

}
