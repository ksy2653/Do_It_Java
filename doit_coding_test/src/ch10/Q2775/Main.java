package ch10.Q2775;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch10/Q2775/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			int[][] dp = new int[k+1][n+1];
			for(int i=1;i<=n;i++) {
				dp[0][i] = i;
			}
			
			for(int i=1;i<=k;i++) {
				for(int j=1;j<=n;j++) {
					dp[i][j] = dp[i][j-1] + dp[i-1][j];
				}
			}
			
			System.out.println(dp[k][n]);
		}
	}

}
