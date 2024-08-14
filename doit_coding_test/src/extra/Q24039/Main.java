package extra.Q24039;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] prime = new int[10001];
		for(int i=1;i<=10000;i++) {
			prime[i]=i;
		}
		for(int i=2;i<=Math.sqrt(10000);i++) {
			if(prime[i]==0)
				continue;
			for(int j=i*2;j<=10000;j=j+i) {
				prime[j]=0;
			}
		}

		for(int i = 2;i<=10000;i++) {
			if(prime[i]==0)
				continue;
			int now = i;
			boolean isPrime=false;
			while(isPrime==false) {
				now++;
				if(prime[now] != 0) {
					isPrime=true;
				}
			}
			
			if(prime[i] * prime[now] > N) {
				System.out.println(prime[i]*prime[now]);
				break;
			}
			
		}
	}
}
