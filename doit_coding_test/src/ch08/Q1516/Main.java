package ch08.Q1516;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch08/Q1516/input.txt"));

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer>[] A = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			A[i] = new ArrayList<>();
		}
		
		int[] time = new int[N+1];
		int[] degree = new int[N+1];
		for(int i=1;i<=N;i++) {
			time[i] = sc.nextInt();
			while(true) {
				int temp = sc.nextInt();
				if(temp == -1)
					break;
				A[temp].add(i);
				degree[i]++;
			}
		}
		
		int[] result = new int[N+1];
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			if(degree[i]==0)
				queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next: A[now]) {
				degree[next]--;
				result[next] = Math.max(result[next], result[now] + time[now]);
				if(degree[next]==0)
					queue.offer(next);
			}
		}
		
		for(int i=1;i<=N;i++) {
			System.out.println(result[i] + time[i]);
		}
	}

}
