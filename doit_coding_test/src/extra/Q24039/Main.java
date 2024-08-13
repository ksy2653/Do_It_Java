package extra.Q24039;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] prime = new int[N+1];
		for(int i=1;i<=N;i++) {
			prime[i]=i;
		}
		for(int i=2;i<=Math.sqrt(N);i++) {
			if(prime[i]==0)
				continue;
			for(int j=i*2;j<=N;j=j+i) {
				prime[j]=0;
			}
		}

		
		int result=0;
		int count=1;

		for(int i=2;i<=N;i++) {
			if(prime[i]*prime[i] > N) {
				result=i;
				break;
			}
		}
		
		for(int i=result-1;i>2;i--) {
			if(prime[i]!=0) {
				count = result*i;
				break;
			}
		}
		
		System.out.println(count);
	}
}
