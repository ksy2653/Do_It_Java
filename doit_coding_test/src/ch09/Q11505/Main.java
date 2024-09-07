package ch09.Q11505;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;
	static int MOD = 1000000007;;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch09/Q11505/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int length=N;
		int treeHeight=0;
		while(length>0) {
			treeHeight++;
			length/=2;
		}
		
		int treeSize = (int)Math.pow(2, treeHeight+1);
		tree = new long[treeSize];
		int leftNodeStartIndex = treeSize/2;
		
		for(int i=0;i<tree.length;i++) {
			tree[i]=1;
		}
		
		for(int i=leftNodeStartIndex;i<leftNodeStartIndex+N;i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		
		setTree(treeSize-1);
		
		for(int i=0;i<M+K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a==1) {
				b = b + leftNodeStartIndex - 1;
				
				changeVal(b,c);
			}
			else if(a==2) {
				b = b + leftNodeStartIndex - 1;
				c = c + leftNodeStartIndex - 1;
				
				System.out.println(getMul(b,(int)c));
			}
			else
				return;
		}
	}
	
	public static void setTree(int i) {
		while(i!=1) {
			tree[i/2] = tree[i/2] * tree[i] % MOD;
			i--;
		}
	}
	
	public static void changeVal(int index, long val) {
		tree[index] = val;
		while(index>1) {
			index /=2;
			tree[index] = tree[index*2] % MOD * tree[index*2+1] % MOD;
		}
	}
	
	public static long getMul(int s, int e) {
		long partMul=1;
		while(s<=e) {
			if(s%2==1) {
				partMul = (partMul * tree[s]) % MOD;
				s++;
			}
			if(e%2==0) {
				partMul = (partMul * tree[e]) % MOD;
				e--;
			}
			
			s/=2;
			e/=2;
		}
		
		return partMul % MOD;
	}

}
