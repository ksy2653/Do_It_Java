package groom.통증;

import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int item=0;
		
		item += N/14;
		N %= 14;
		
		item += N/7;
		N %= 7;
		
		item += N;
		
		System.out.println(item);
	}
}
