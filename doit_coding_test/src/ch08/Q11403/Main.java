package ch08.Q11403;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] distance;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch08/Q11403/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		distance = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				distance[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(distance[i][k] == 1 && distance[k][j] == 1)
						distance[i][j] = 1;
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}
	}

}
