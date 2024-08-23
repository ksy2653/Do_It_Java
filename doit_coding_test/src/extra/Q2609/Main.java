package extra.Q2609;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int gcd = gcd(A,B);
		int lcm = gcd * (A/gcd) * (B/gcd);
		
		System.out.println(gcd);
		System.out.println(lcm);
	}
	
	public static int gcd(int a, int b) {
		if(a % b == 0)
			return b;
		else
			return gcd(b,a%b);
	}

}
