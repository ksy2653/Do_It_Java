package ch05.Q1167;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static boolean[] visited;
	static int[] distance;
	static ArrayList<Edge>[] A;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch05/Q1167/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			A[i] = new ArrayList<Edge>();
		}
		
		for(int i=0;i<N;i++) {
			int S = sc.nextInt();
			while(true) {
				int E = sc.nextInt();
				if(E==-1)
					break;
				int V = sc.nextInt();
				
				A[S].add(new Edge(E,V));
			}
		}
		
		visited = new boolean[N+1];
		distance = new int[N+1];
		int max=1;
		bfs(1);
		
		for(int i=2;i<=N;i++) {
			if(distance[max] < distance[i])
				max=i;
		}
		
		visited = new boolean[N+1];
		distance = new int[N+1];
		bfs(max);
		
		Arrays.sort(distance);
		
		System.out.println(distance[N]);
	}
	
	public static void bfs(int index) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);
		visited[index] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(Edge i:A[current]) {
				int e = i.e;
				int v = i.value;
				
				if(!visited[e]) {
					queue.add(e);
					visited[e] = true;
					distance[e] = distance[current] + v;
				}
			}
		}
	}

}

class Edge{
	int e;
	int value;
	
	public Edge(int e, int value) {
		this.e = e;
		this.value = value;
	}
}

/*
 * Edge class 생성해서 e와 value 값을 갖도록
 * A list를 만드는데 Edge값들을 갖는 list
 * 임의의 값에서 bfs를 돌려서 distance값이 max인 값을 추출 -> 그 노드가 지름의 한 노드
 * bfs(max)로 다시 호출
 * distance값을 정렬하고 최댓값이 지름의 값
*/
