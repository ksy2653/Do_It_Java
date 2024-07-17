package ch07.Q1929;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch07/Q1929/input.txt"));

		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int[] A = new int[N+1];
		for(int i=2;i<=N;i++) {
			A[i] = i;
		}
		
		for(int i=2;i<=Math.sqrt(N);i++) {
			if(A[i] == 0)
				continue;
			for(int j=i*2;j<=N;j=j+i) {
				A[j]=0;
			}
		}
		
		for(int i=M;i<=N;i++) {
			if(A[i]!=0)
				System.out.println(A[i]);
		}
	}

}
