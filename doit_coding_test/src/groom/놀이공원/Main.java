package groom.놀이공원;

import java.io.*;
import java.util.*;

class Main {
	static int N,K,trash;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int min=K*K;
			for(int i=0;i<=N-K;i++){
				for(int j=0;j<=N-K;j++){
					trash=0;
					dfs(i,j);
					min = Math.min(min,trash);
				}
			}
			
			System.out.println(min);
		}
	}
	
	public static void dfs(int x, int y){
		for(int i=x;i<x+K;i++){
			for(int j=y;j<y+K;j++){
				if(map[i][j]==1)
					trash++;
			}
		}
		
	}
}