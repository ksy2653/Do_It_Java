package main;

import java.io.BufferedReader;	
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int[][] tree;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		tree = new int[26][2];
		
		for(int i=0;i<n;i++) {
			String[] temp = sc.nextLine().split(" ");
			int node = temp[0].charAt(0) - 'A';
			char left = temp[1].charAt(0);
			char right = temp[2].charAt(0);
			
			if(left == '.')
				tree[node][0] = -1;
			else
				tree[node][0] = left - 'A';
			if(right == '.')
				tree[node][1] = -1;
			else
				tree[node][1] = right - 'A';
		}
		
		preOrder(0);
		System.out.println();
		InOrder(0);
		System.out.println();
		postOrder(0);
		System.out.println();
	}
	
	public static void preOrder(int now) {
		if(now == -1)
			return;
		System.out.print((char)(now+'A'));
		preOrder(tree[now][0]);
		preOrder(tree[now][1]);
	}
	
	public static void InOrder(int now) {
		if(now == -1)
			return;
		InOrder(tree[now][0]);
		System.out.print((char)(now+'A'));
		InOrder(tree[now][1]);
	}
	
	public static void postOrder(int now) {
		if(now == -1)
			return;
		postOrder(tree[now][0]);
		postOrder(tree[now][1]);
		System.out.print((char)(now+'A'));
	}
	
}