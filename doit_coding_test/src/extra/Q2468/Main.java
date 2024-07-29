package extra.Q2468;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 첫째 줄에는 어떤 지역을 나타내는 2차원 배열의 행과 열의 개수를 나타내는 수 N이 입력된다. 
	// N은 2 이상 100 이하의 정수이다. 둘째 줄부터 N개의 각 줄에는 2차원 배열의 첫 번째 행부터 N번째 행까지 순서대로 한 행씩 높이 정보가 입력된다. 
	// 각 줄에는 각 행의 첫 번째 열부터 N번째 열까지 N개의 높이 정보를 나타내는 자연수가 빈 칸을 사이에 두고 입력된다. 높이는 1이상 100 이하의 정수이다.

	static int N,max,count,count_max;
	static int[][] height;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/extra/Q2468/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		height = new int[N][N];
		visited = new boolean[N][N];
		max =0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
				if(height[i][j] > max)
					max = height[i][j];
			}
		}
		
		count_max=0;
		
		int rain = 0;
		while(rain <= max) {
			count=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j] && height[i][j] > rain) {
						count++;
						dfs(i,j,rain);
					}
				}
			}
			
			if(count_max < count)
				count_max = count;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(visited[i][j] == true)
						visited[i][j] = false;
				}
			}
			
			rain++;
		}
		
		System.out.println(count_max);
	}
	
	public static void dfs(int x, int y, int rain) {
		if(visited[x][y])
			return;
		visited[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if(0<=newX && newX <N && 0<=newY && newY <N && !visited[newX][newY] && height[newX][newY] > rain)
				dfs(newX,newY,rain);
		}
	}

}
