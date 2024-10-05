package groom.구름이의_취미;

import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long mod = 1000000007;
		
		// 공식: (N * (N + 1) / 2)^2 % mod
		long sum = N * (N + 1) / 2;   // N(N+1)/2의 값을 계산
		sum %= mod;                   // mod 연산을 먼저 적용
		long V_sum = (sum * sum) % mod;  // 최종적으로 세제곱의 합을 구함
		
		System.out.println(V_sum);
	}
}
