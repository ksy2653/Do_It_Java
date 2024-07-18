package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		long B = sc.nextLong();
		int max = 10000001;
		
		long num[] = new long[max];
		for(int i=2;i<max;i++) {
			num[i]=i;
		}
		
		for(int i=2;i<Math.sqrt(max);i++) {
			if(num[i]==0)
				continue;
			for(int j=i*2;j<max;j=j+i) {
				num[j]=0;
			}
		}
		
		int count=0;
		for(int i=2;i<max;i++) {
			if(num[i]!=0) {
				long temp = num[i];
				while((double)num[i] <= (double)B/(double)temp) {
					if((double)num[i] >= (double)A/(double)temp)
						count++;
					
					temp *= num[i];
				}
			}
		}
		
		System.out.println(count);
		
	}
	
}
