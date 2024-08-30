package extra.Q9934;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N,nodes;
	static int[] tree;
	static ArrayList<Integer> levels[];

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/extra/Q9934/input.txt"));

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nodes = (int) Math.pow(2, N) - 1;
		
		tree = new int[nodes];
		levels = new ArrayList[N];
		for(int i=0;i<N;i++) {
			levels[i] = new ArrayList<>();
		}
		
		for(int i=0;i<nodes;i++) {
			tree[i] = sc.nextInt();
		}
		
		buildTree(tree,0,nodes-1,0);
		
		for(int i=0;i<N;i++) {
			for(int val:levels[i]) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
	
	public static void buildTree(int[] tree, int s, int e, int level) {
		if(s>e)
			return;
		int mid = (s+e)/2;
		levels[level].add(tree[mid]);
		
		buildTree(tree,s,mid-1,level+1);
		buildTree(tree,mid+1,e,level+1);
		
	}

}
