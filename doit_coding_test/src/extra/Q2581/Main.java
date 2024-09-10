package extra.Q2581;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int[] prime = new int[N+1];
		for(int i=2;i<=N;i++) {
			prime[i]=i;
		}
		
		for(int i=2;i<=Math.sqrt(N);i++) {
			if(prime[i]==0)
				continue;
			for(int j=i*2;j<=N;j=j+i) {
				prime[j]=0;
			}
		}
		
		int sum=0;
		int min=Integer.MAX_VALUE;
		for(int i=M;i<=N;i++) {
			if(prime[i]!=0) {
				sum += prime[i];
				min = Math.min(min, prime[i]);
			}
		}
		
		if(sum==0)
			System.out.println(-1);
		else
		{
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
