package ch05.Q7569;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M,N,H;
	static int[][][] tomato;
	static int[] dx = {0,0,-1,1,0,0};
	static int[] dy = {-1,1,0,0,0,0};
	static int[] dz = {0,0,0,0,-1,1};

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch05/Q7569/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		tomato = new int[H][N][M];
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<M;k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					if(tomato[i][j][k] == 1)
						queue.add(new int[] {i,j,k});
				}
			}
		}
		
		int depth = bfs(queue);
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(tomato[i][j][k] == 0)
						depth = -1;
				}
			}
		}
		
		System.out.println(depth);
		
	}
	
	public static int bfs(Queue<int[]> queue) {
		int depth = -1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				int[] current = queue.poll();
				int cx = current[2];
				int cy = current[1];
				int cz = current[0];
				
				for(int j=0;j<6;j++) {
					int newX = cx + dx[j];
					int newY = cy + dy[j];
					int newZ = cz + dz[j];
					
					if (0 <= newX && newX < M && 0 <= newY && newY < N && 0 <= newZ && newZ < H 
							&& tomato[newZ][newY][newX] == 0) {
						
						tomato[newZ][newY][newX] = 1;
						queue.add(new int[] {newZ,newY,newX});
					}
				}
			}
			depth++;
		}
		
		return depth;
	}
}