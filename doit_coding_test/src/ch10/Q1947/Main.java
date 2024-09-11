package ch10.Q1947;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long[] dp = new long[N+1];
		dp[1] = 0;
		dp[2] = 1;
		for(int i=3;i<=N;i++) {
			dp[i] = (i-1)*(dp[i-1] + dp[i-2]) % 1000000000;
			
		}
		
		System.out.println(dp[N]);

	}

}
