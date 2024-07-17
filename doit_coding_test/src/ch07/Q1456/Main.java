package ch07.Q1456;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		long B = sc.nextLong();
		long[] num = new long[10000001];
		
		for(int i=2;i<num.length;i++) {
			num[i]=i;
		}
		
		for(int i=2;i<=Math.sqrt(num.length-1);i++) {
			if(num[i]==0)
				continue;
			for(int j=i*2;j<num.length;j=j+i) {
				num[j]=0;
			}
		}
		
		int count=0;
		for(int i=2;i<10000001;i++) {
			if(num[i]!=0) {
				long temp=num[i];
				while((double)num[i] <= (double)B/(double)temp) {
					if((double)num[i] >= (double)A/(double)temp)
						count++;
					
					temp = temp*num[i];
				}
			}
		}
		
		System.out.println(count);

	}

}
