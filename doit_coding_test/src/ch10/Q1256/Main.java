package ch10.Q1256;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		long K = sc.nextLong();
		
		long[][] dp = new long[202][202];
		for(int i=0;i<=N+M;i++) {
			dp[i][0] = 1;
			dp[i][1] = i;
			dp[i][i] = 1;
		}
		
		for(int i=1;i<=N+M;i++) {
			for(int j=1;j<=i;j++) {
				dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				
				if(dp[i][j] > 1000000000)
					dp[i][j] = 1000000001;
			}
		}
		
		if(K<1 || K > dp[N+M][N]) {
			System.out.println(-1);
			return;
		}
		
		while(!(N==0&&M==0)) {
			if(dp[N+M-1][M]>=K) {
				bw.append('a');
				N -= 1;
			}
			else {
				bw.append('z');
				K -= dp[N+M-1][M];
				M -= 1;
			}
		}
		
		bw.flush();
		bw.close();
	}


}