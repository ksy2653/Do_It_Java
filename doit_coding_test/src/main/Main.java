package main;

import java.io.BufferedReader;	
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/main/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		BigInteger[][] dp = new BigInteger[101][101];
		
		for(int i = 1; i <= N; i++){
			for(int j = 0; j<= i; j++){
				if(j == 0 || i == j){
					dp[i][j] = new BigInteger(String.valueOf(1));
				}else{
					dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
				}
			}
		}
		
		System.out.println(dp[N][M]);
		
		
	}
	
}