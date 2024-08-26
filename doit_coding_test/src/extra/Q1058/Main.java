package extra.Q1058;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] distance;
	static int[] friends;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/extra/Q1058/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		distance = new int[N][N];
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<N;j++) {
				if(i==j)
					distance[i][j]=0;
				else if(line.charAt(j) == 'Y')
					distance[i][j] = 1;
				else 
					distance[i][j] = 100000;
			}
		}
		
		friends = new int[N];
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(distance[i][k] + distance[k][j] < distance[i][j])
						distance[i][j] = distance[i][k] + distance[k][j];
				}
			}
		}
		
		int max=0;
		for(int i=0;i<N;i++) {
			int temp=0;
			for(int j=0;j<N;j++) {
				if(distance[i][j] == 1 || distance[i][j] == 2)
					temp++;
			}
			
			max = Math.max(max, temp);
		}
		
		System.out.println(max);
	}

}
