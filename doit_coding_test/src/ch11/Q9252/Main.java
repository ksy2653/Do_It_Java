package ch11.Q9252;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	private static long[][] dp;
	private static ArrayList<Character> Path;
	private static char[] A;
	private static char[] B;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch11/Q9252/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine().toCharArray();
		B = br.readLine().toCharArray();
		
		dp = new long[A.length+1][B.length+1];
		Path = new ArrayList<>();
		for(int i=1;i<=A.length;i++) {
			for(int j=1;j<=B.length;j++) {
				if(A[i-1] == B[j-1])
					dp[i][j] = dp[i-1][j-1]+1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		System.out.println(dp[A.length][B.length]);
		
		getText(A.length,B.length);
		
		for(int i = Path.size()-1;i>=0;i--) {
			System.out.print(Path.get(i));
		}
		
	}
	
	private static void getText(int r, int c) {
		if(r==0 || c==0)
			return;
		if(A[r-1]==B[c-1]) {
			Path.add(A[r-1]);
			getText(r-1,c-1);
		}
		else {
			if(dp[r-1][c] > dp[r][c-1]) 
				getText(r-1,c);
			else
				getText(r,c-1);	
		}
	}

}
