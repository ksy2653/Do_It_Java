package ch09.Q10868;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] tree;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch09/Q10868/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int length=N;
		int treeHeight=0;
		while(length>0) {
			treeHeight++;
			length/=2;
		}
		
		int treeSize = (int)Math.pow(2, treeHeight+1);
		tree = new int[treeSize];
		int leftStartNodeIndex = treeSize/2;
		
		for(int i=leftStartNodeIndex;i<leftStartNodeIndex+N;i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}
		
		setTree(treeSize-1);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			s = s + leftStartNodeIndex - 1;
			e = e + leftStartNodeIndex - 1;
			
			System.out.println(getMin(s,e));
		}
	}
	
	public static void setTree(int i){
		while(i>1) {
			if(tree[i] == 0 && tree[i-1] == 0) {
				tree[i/2] = 0;
				i = i-2;
			}
			else if(tree[i] == 0) {
				tree[i/2] = tree[i-1];
				i = i-2;
			}
			else {
				tree[i/2] = Math.min(tree[i], tree[i-1]);
				i = i-2;
			}
		}
	}
	
	public static int getMin(int s, int e) {
		int Min = Integer.MAX_VALUE;
		
		while(s<=e) {
			if(s%2==1) {
				Min = Math.min(Min, tree[s]);
				s++;
			}
			if(e%2==0) {
				Min = Math.min(Min, tree[e]);
				e--;
			}
			
			s /=2;
			e /=2;
		}
		
		return Min;
	}
	

}
