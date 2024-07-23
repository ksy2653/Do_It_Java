package ch07.Q1033;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static long lcm;
    static ArrayList<cNode> A[];
    static boolean visited[];
    static long D[];

    public static void main(String[] args) throws IOException {
    	System.setIn(new FileInputStream("src/ch07/Q1033/input.txt"));

    	Scanner sc = new Scanner(System.in);
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	N = sc.nextInt();
    	A = new ArrayList[N];
    	visited = new boolean[N];
    	D = new long[N];
    	lcm=1;
    	for (int i = 0; i < N; i++) {
			A[i]=new ArrayList<cNode>();
		}
    	
    	for (int i = 0; i < N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			A[a].add(new cNode(b,p,q));
			A[b].add(new cNode(a,q,p));
			
			lcm *= (p*q / gcd(p,q));
		}
    	
    	D[0] = lcm;
    	dfs(0);
    	long mgcd = D[0];
    	
    	for(int i=1;i<N;i++) {
    		mgcd = gcd(mgcd, D[i]);
    	}
    	
    	for (int i = 0; i < N; i++) {
			System.out.print(D[i]/mgcd + " ");
		}
    	
    }
    
    public static long gcd(long a, long b) {
    	if(b==0)
    		return a;
    	else
    		return gcd(b,a%b);
    }
    
    public static void dfs(int Node) {
    	visited[Node] = true;
    	for(cNode i : A[Node]) {
    		int next = i.getB();
    		if(!visited[next]) {
    			D[next] = D[Node] * i.getQ() / i.getP();
    			dfs(next);
    		}
    	}
    }

}

class cNode{
	int b;
	int p;
	int q;
	
	
	public cNode(int b, int p, int q) {
		super();
		this.b = b;
		this.p = p;
		this.q = q;
	}
	
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getQ() {
		return q;
	}
	public void setQ(int q) {
		this.q = q;
	}
	
	
}
