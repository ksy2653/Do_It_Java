package ch10.Q1010;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch10/Q1010/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] dp = new int[M+1][M+1];
			for(int i=1;i<=M;i++) {
				dp[i][0] = 1;
				dp[i][1] = i;
				dp[i][i] = 1;
			}
			
			for(int i=2;i<=M;i++) {
				for(int j=2;j<i;j++) {
					dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				}
			}
			
			System.out.println(dp[M][N]);
		}
	}

}
