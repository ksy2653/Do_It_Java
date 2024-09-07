package extra.Q1065;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count=0;
		for(int i=1;i<=N;i++) {
			if(isHansu(i))
				count++;
		}
		
		System.out.println(count);

	}
	
	public static boolean isHansu(int n) {
		if(n<1)
			return false;
		if(n<100)
			return true;
		if(n==1000)
			return false;
		int a = n / 100;
		int b = (n % 100) / 10;
		int c = n % 10;
		
		if(a-b == b-c)
			return true;
		else
			return false;
	}

}
