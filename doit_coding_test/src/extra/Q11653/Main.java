package extra.Q11653;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
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
		
		for(int i=2;i<=N;i++) {
			if(prime[i]==0)
				continue;
			if(N % prime[i] != 0)
				continue;
			while(N % prime[i] == 0) {
				System.out.println(prime[i]);
				N /= prime[i];
			}
			if(N==1)
				break;
		}

	}

}
