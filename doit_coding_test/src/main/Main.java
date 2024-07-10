package main;

import java.io.BufferedReader;		
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static boolean[][] visited;
	static int[][] maze;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M];
		maze = new int[N][M];
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				maze[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}
		
		int result = bfs(0,0);
		System.out.println(result);
	}
	
	
	public static int bfs(int x, int y) {
		int depth=1;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int j=0;j<size;j++) {
				int current[] = queue.poll();
				int cx = current[0];
				int cy = current[1];
				
				if(cx == N-1 && cy == M-1)
					return depth;
				
				for(int i=0;i<4;i++) {
					int newX = dx[i] + cx;
					int newY = dy[i] + cy;
					
					if(0<=newX && newX<N && 0<=newY && newY<M
							&& !visited[newX][newY] && maze[newX][newY] == 1) {
						queue.add(new int[] {newX, newY});
						visited[newX][newY] = true;
					}
				}
			}
			depth++;
		}
		
		return -1;
	}
}