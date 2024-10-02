package ch11.Q10844;

import java.util.Scanner;

public class Main {
	static long mod = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] dp = new long[101][10];
		
		for(int i=1;i<=9;i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<=9;j++) {
				if(j==0)
					dp[i][j] = dp[i-1][1] % mod;
				else if(j==9)
					dp[i][j] = dp[i-1][8] % mod;
				else
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
			}
		}
		
		long result=0;
		for(int i=0;i<=9;i++) {
			result = (result + dp[N][i]) % mod;
		}
		
		System.out.println(result);

	}

}