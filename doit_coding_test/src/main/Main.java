package main;

import java.io.BufferedReader;		
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		Arrays.sort(A);
		
		int M = sc.nextInt();
		for(int i=0;i<M;i++) {
			boolean find = false;
			int target = sc.nextInt();
			
			int start=0;
			int end=A.length-1;
			
			while(start<=end) {
				int midi = (start+end)/2;
				int midV = A[midi];
				
				if(midV > target)
					end = midi-1;
				else if(midV < target)
					start = midi+1;
				else {
					find = true;
					break;
				}
			}
			
			if(find)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
	
}