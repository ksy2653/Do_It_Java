package ch10.Q13251;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		
		int dp[] = new int[M];
		int entire=0;
		for(int i=0;i<M;i++) {
			dp[i] = sc.nextInt();
			entire += dp[i];
		}
		
		double probability[] = new double[M];
		Arrays.fill(probability, 1.0);
		double ans=0;
		int K = sc.nextInt();
		
		for(int i=0;i<M;i++) {
			if(dp[i] < K) {
				probability[i]=0;
				continue;
			}
			for(int j=0;j<K;j++) {
				probability[i] = probability[i] * (double)(dp[i]-j)/(entire-j);
			}
			
			ans += probability[i];
		}
		
		System.out.println(ans);

	}

}
