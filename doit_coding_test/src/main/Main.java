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
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int Q = Integer.parseInt(st.nextToken());

		boolean visited[] = new boolean[N+1];
		long[] F = new long[N+1];
		int[] S = new int[N+1];
		F[0]=1;
		for(int i=1;i<=N;i++) {
			F[i] = i * F[i-1];
		}
		
		
		if(Q==1) {
			long K = Long.parseLong(st.nextToken());
			for(int i=1;i<=N;i++) {
				for(int j=1,cnt=1;j<=N;j++) {
					if(visited[j])
						continue;
					if(K<=cnt*F[N-i]) {
						K -= (cnt-1) * F[N-i];
						S[i]=j;
						visited[j]=true;
						break;
					}
					
					cnt++;
				}
			}
			
			for(int i=1;i<=N;i++) {
				System.out.print(S[i]+" ");
			}
		}
		
		else if(Q==2) {
			long K = 1;
			for(int i=1;i<=N;i++) {
				S[i] = Integer.parseInt(st.nextToken());
				long cnt=0;
				for(int j=1;j<S[i];j++) {
					if(visited[j]==false)
						cnt++;
				}
				
				K += cnt*F[N-i];
				visited[S[i]] = true;
			}
			
			System.out.println(K);
		}
		
		else
			return;
		
	}
	
}