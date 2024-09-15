package ch11.Q14501;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src/ch11/Q14501/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] dp = new int[21];
		int[] t = new int[21];
		int[] p = new int[21];
		
		
		for(int i=1;i<=N;i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		for(int i=N;i>=1;i--) {
			if(i + t[i] - 1 > N)
				dp[i]=dp[i+1];
			else
				dp[i] = Math.max(dp[i+1],dp[i+t[i]]+p[i]);
		}
		
		System.out.println(dp[1]);
	}

}
