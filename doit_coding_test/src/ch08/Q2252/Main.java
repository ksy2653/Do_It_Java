package ch08.Q2252;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] degree = new int[N+1];
		ArrayList<Integer>[] A = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			A[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			A[s].add(e);
			degree[e]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			if(degree[i]==0)
				queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			for(int next: A[now]) {
				degree[next]--;
				if(degree[next]==0)
					queue.offer(next);
			}
		}
		
	}

}
