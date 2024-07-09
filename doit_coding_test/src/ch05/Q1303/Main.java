package ch05.Q1303;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static boolean[][] visited;
	static char[][] soldiers;
	static int ally, enemy;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch05/Q1303/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[M+1][N+1];
		soldiers = new char[M+1][N+1];
		
		for(int i=1;i<=M;i++) {
			String line = br.readLine();
			for(int j=1;j<=N;j++) {
				soldiers[i][j] = line.charAt(j-1);
			}
		}
		
		for(int i=1;i<=M;i++) {
			for(int j=1;j<=N;j++) {
				if(!visited[i][j]) {
					int num = bfs(i,j);
					if(soldiers[i][j] == 'W')
						ally += num*num;
					else if(soldiers[i][j] == 'B')
						enemy +=num*num;
				}
			}
		}
		
		
		System.out.println(ally + " " + enemy);
	}
	
	public static int bfs(int x, int y) {
		int count=0;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int current[] = queue.poll();
			int cx = current[0];
			int cy = current[1];
			count++;
			
			for(int i=0;i<4;i++) {
				int newX = dx[i] + cx;
				int newY = dy[i] + cy;
				
				if(0<newX && newX <=M && 0<newY && newY<=N && !visited[newX][newY]
						&& soldiers[newX][newY] == soldiers[cx][cy]) {
					queue.add(new int[] {newX, newY});
					visited[newX][newY] = true;
				}
			}
		}
		
		return count;
	}

}
