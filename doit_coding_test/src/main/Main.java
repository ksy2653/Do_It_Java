package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int T,N,M,K;
	static boolean[][] visited, cabbage;
	static int worm;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//worm_list = new ArrayList<>();
		T = Integer.parseInt(st.nextToken());
		for(int i=0;i<T;i++) {
			worm =0;
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			cabbage = new boolean[N][M];
			visited = new boolean[N][M];
			
			for(int j=0;j<K;j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				cabbage[y][x] = true;
			}
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(!visited[j][k] && cabbage[j][k]) {
						worm++;
						dfs(j,k);
					}
				}
			}
			System.out.println(worm);
		}
	}
	
	public static void dfs(int x, int y) {
		if(visited[x][y] || !cabbage[x][y])
			return;
		visited[x][y] = true;
		for(int i=0;i<4;i++) {
			int newX = dx[i] + x;
			int newY = dy[i] + y;
			if(0<= newX && newX <N && 0<=newY && newY<M && !visited[newX][newY] && cabbage[newX][newY])
				dfs(newX,newY);
		}
	}
}