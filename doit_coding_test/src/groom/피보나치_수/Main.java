package groom.피보나치_수;

import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int mod = 1000000007;
		int[] F = new int[100001];
		F[1]=0;
		F[2]=1;
		
		for(int i=3;i<=K;i++){
			F[i] = (F[i-1] + F[i-2]) % mod;
		}
		
		System.out.println(F[K]);
	}
}
