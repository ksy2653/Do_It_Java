package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M,K,X;
	static int[] visited;
	static ArrayList<Integer> list[];
	static ArrayList<Integer> answer;
	
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		X = sc.nextInt();
		
		visited = new int[N+1];
		list = new ArrayList[N+1];
		answer = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
			visited[i]=-1;
		}
		
		for(int i=0;i<M;i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			list[s].add(e);
		}
		
		bfs(X);
		
		for(int i=1;i<=N;i++) {
			if(visited[i] == K)
				answer.add(i);
		}
		
		if(answer.isEmpty())
			System.out.println(-1);
		else {
			for(int temp:answer) {
				System.out.println(temp);
			}
		}
	}
	
	public static void bfs(int Node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(Node);
		visited[Node]++;
		
		while(!queue.isEmpty()) {
			int now_Node = queue.poll();
				for(int i:list[now_Node]) {
					if(visited[i]==-1) {
						queue.add(i);
						visited[i] = visited[now_Node]+1;
				}
			}
		}
	}
}

//첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X가 주어진다.
//(2 ≤ N ≤ 300,000, 1 ≤ M ≤ 1,000,000, 1 ≤ K ≤ 300,000, 1 ≤ X ≤ N) 
//X로부터 출발하여 도달할 수 있는 도시 중에서, 최단 거리가 K인 모든 도시의 번호를 한 줄에 하나씩 오름차순으로 출력한다.
//이 때 도달할 수 있는 도시 중에서, 최단 거리가 K인 도시가 하나도 존재하지 않으면 -1을 출력한다.
