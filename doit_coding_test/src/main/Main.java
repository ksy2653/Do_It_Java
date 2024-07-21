package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		long N = sc.nextLong();
		long A[] = new long[(int)N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextLong();
		}
		
		long B = sc.nextLong();
		long C = sc.nextLong();
		
		long count=0;
		for (int i = 0; i < N; i++) {
			if(A[i]<=B)
				count++;
			else {
				count++;
				A[i] -=B;
				if(A[i] % C == 0) {
					count = count + (A[i] / C);
				}
				else
					count = count + (A[i] / C) + 1;
			}
		}
		
		System.out.println(count);
		
	}
	
}
