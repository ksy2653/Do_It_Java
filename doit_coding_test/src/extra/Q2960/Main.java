package extra.Q2960;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] A = new int[N+1];
		for(int i=1;i<=N;i++) {
			A[i]=i;
		}
		int count=0;
		
		for(int i=2;i<=Math.sqrt(N);i++) {
			if(A[i]==0)
				continue;
			count++;
			for(int j=i*2;j<=N;j=j+i) {
				if(A[j] != 0) {
					count++;
					if(count==K) {
						System.out.println(A[j]);
						return;
					}
					A[j]=0;
				}
			}
		}
		
		
		for(int current = (int) Math.sqrt(N)+1;current<=N;current++) {
			if(A[current] != 0 ) {
				count++;
				if(count == K) {
					System.out.println(A[current]);
					return;
				}
			}
		}
	}

}
