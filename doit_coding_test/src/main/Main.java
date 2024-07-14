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
		int M = sc.nextInt();
		
		int[] lecture = new int[N];
		for (int i = 0; i < N; i++) {
			lecture[i] = sc.nextInt();
		}
		
		int max=0;
		int sum=0;
		
		for (int i = 0; i < N; i++) {
			if(lecture[i] > max)
				max = lecture[i];
			sum+=lecture[i];
		}
		
		int left = max;
		int right = sum;
		
		while(left<=right) {
			int mid = (left+right)/2;
			int count=0;
			int length=0;
			
			for(int i=1;i<N;i++) {
				if(length + lecture[i] > mid) {
					count++;
					length=0;
				}
				length+=lecture[i];
			}
			if(length!=0)
				count++;
			
			if(count>M)
				left = mid+1;
			else
				right=mid-1;
		}
		
		System.out.println(left);
	}
	
}