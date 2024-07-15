package ch06.Q11047;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int N,K;
	static int[] A;
	static int count=0;

	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src/ch06/Q11047/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i=N-1;i>=0;i--) {
			if(A[i] <= K) {
				int num = K/A[i];
				count += num;
				K -= num*A[i];
			}
		}
		
		System.out.println(count);
	}
}
