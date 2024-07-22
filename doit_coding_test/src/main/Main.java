package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count=0;
		for (int i = 0; i < N; i++) {
			int num=sc.nextInt();
			if(isPrime(num))
				count++;
		}
		
		System.out.println(count);
		
	}
	
	public static boolean isPrime(int num) {
		int[] A = new int[num+1];
		for(int i=2;i<=num;i++) {
			A[i]=i;
		}
		
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(A[i]==0)
				continue;
			for(int j=i*2;j<=num;j=j+i) {
				A[j]=0;
			}
		}
		
		if(A[num]==0)
			return false;
		else
			return true;
	}
}
