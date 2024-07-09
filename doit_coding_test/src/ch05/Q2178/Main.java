package ch05.Q2178;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static boolean[][] visited, maze;
	static int depth;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch05/Q2178/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1][M+1];
		maze = new boolean[N+1][M+1];
		
		for(int i=1;i<=N;i++) {
			String line = br.readLine();
			for(int j=1;j<=M;j++) {
				maze[i][j] = line.charAt(j-1) == '1';
			}
		}
		
		bfs(1,1);
		
		System.out.println(depth);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		depth=1;
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				int[] current = queue.poll();
				int cx = current[0];
				int cy = current[1];
				
				if(cx == N && cy ==M)
					return;
				
				for(int j=0;j<4;j++) {
					int newX = cx + dx[j];
					int newY = cy + dy[j];
					
					if(0<newX && newX <=N && 0<newY && newY<=M
							&& !visited[newX][newY] && maze[newX][newY]) {
						queue.add(new int[] {newX,newY});
						visited[newX][newY] = true;
					}
				}
			}
			depth++;
			
		}
	
	}
}
