package ch05.friendship;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// Baekjoon Q13023
public class Friendship {
	static int N,M,count;
	static boolean visited[];
	static ArrayList<Integer>[] friendList;
	static boolean found;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch05/friendship/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		friendList = new ArrayList[N];
		for(int i=0;i<N;i++) {
			friendList[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			friendList[s].add(e);
			friendList[e].add(s);
		}
		
		visited = new boolean[N];
		found = false;
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
                dfs(i, 1);
            }
			if(found)
				break;
		}
		
		System.out.println(found ? 1:0);
		
	}
	
	public static void dfs(int node, int depth) {
		if(depth == 5) {
			found=true;
			return;
		}
		visited[node]=true;
		for(int i:friendList[node]) {
			if(!visited[i]) {
				dfs(i,depth+1);
				if(found) return;
			}
		}
		visited[node]=false;
	}

}
