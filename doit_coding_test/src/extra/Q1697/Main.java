package extra.Q1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,K;
	static int MAX = 100001;
	static int visited[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		visited = new int[MAX];
		
		int answer = bfs(N,K);
		
		System.out.println(answer);

	}
	
	public static int bfs(int start, int end) {
		if(start==end)
			return 0;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = 0;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int i: a(current)) {
				if(i==end) {
					return visited[current]+1;
				}
				if(visited[i]==0 && i<MAX && i>=0) {
					visited[i] = visited[current]+1;
					queue.add(i);
				}
			}
		}
		
		return -1;
	}
	
	public static int[] a(int x) {
		int[] ans = {x-1,x+1,x*2};
		return ans;
	}

}
/*
*수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다.
*만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
*/