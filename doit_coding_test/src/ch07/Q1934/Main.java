package ch07.Q1934;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch07/Q1934/input.txt"));

		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		
		for(int i=0;i<K;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int result = A*B/gcd(A,B);
			System.out.println(result);
		}
	}
	
	public static int gcd(int a, int b) {
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
	}

}
