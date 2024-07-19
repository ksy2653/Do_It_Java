package ch07.Q1850;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long oneA = sc.nextLong();
		long oneB = sc.nextLong();
		
		long gcd = gcd(oneA,oneB);
		
		while(gcd>0) {
			bw.write("1");
			gcd--;
		}
		
		bw.flush();
		bw.close();
	}
	
	public static long gcd(long a, long b) {
		if(b==0)
			return a;
		else
			return gcd(b, a%b);
	}

}
