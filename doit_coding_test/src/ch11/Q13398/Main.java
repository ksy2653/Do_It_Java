package ch11.Q13398;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch11/Q13398/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] L = new int[N];
		int[] R = new int[N];
		L[0] = list[0];
		R[N-1] = list[N-1];
		
		int result = L[0];
		for(int i=1;i<N;i++) {
			L[i] = Math.max(list[i], L[i-1] + list[i]);
			result = Math.max(result, L[i]);
		}
		
		for(int i=N-2;i>=0;i--) {
			R[i] = Math.max(list[i], R[i+1]+list[i]);
		}
		
		for(int i=1;i<N-1;i++) {
			int temp = L[i-1]+R[i+1];
			result = Math.max(result, temp);
		}
		
		System.out.println(result);
	}

}

//첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다. 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
