package ch11.Q2193;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[91];
		
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		
		for(int i=4;i<=N;i++) {
			long sum=0;
			for(int j=i-2;j>=2;j--) {
				sum += dp[j];
			}
			
			dp[i] = sum + 2;
		}
		
		System.out.println(dp[N]);
	}

}
