package ch08.Q18352;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
//첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X가 주어진다.

public class Main {
	static int city,road,distance,start_city;
	static int[] visited;
	static ArrayList<Integer> direction[];
	static ArrayList<Integer> answer;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch08/Q18352/input.txt"));

		Scanner sc = new Scanner(System.in);
		city = sc.nextInt();
		road = sc.nextInt();
		distance = sc.nextInt();
		start_city = sc.nextInt();
		
		direction = new ArrayList[city+1];
		for(int i=1;i<=city;i++) {
			direction[i] = new ArrayList<>();
		}
		
		for(int i=0;i<road;i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			direction[s].add(e);
		}
		
		visited = new int[city+1];
		answer = new ArrayList<>();
		
		for(int i=1;i<=city;i++) {
			visited[i]=-1;
		}
		
		bfs(start_city);
		
		for(int i=0;i<=city;i++) {
			if(visited[i] == distance)
				answer.add(i);
		}
		
		if(answer.isEmpty())
			System.out.println(-1);
		else {
			Collections.sort(answer);
			for(int temp:answer) {
				System.out.println(temp);
			}
		}
	}

	private static void bfs(int Node) {
		Queue<Integer> queue = new LinkedList<>();
		visited[Node]++;
		queue.add(Node);
		
		while(!queue.isEmpty()) {
			int now_Node = queue.poll();
			for(int i : direction[now_Node]) {
				if(visited[i] == -1) {
					queue.add(i);
					visited[i] = visited[now_Node]+1;
				}
			}
		}
	}
}
