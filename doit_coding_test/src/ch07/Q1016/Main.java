package ch07.Q1016;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		long min = sc.nextLong();
		long max = sc.nextLong();
		
		boolean[] check = new boolean[(int)(max-min+1)];
		for(int i=2;i*i<=max;i++) {
			int pow = i*i;
			int start_index = (int)min/pow;
			if(min%pow !=0)
				start_index++;
			
			for(int j=start_index;j*pow<=max;j++) {
				check[(int)(j*pow-min)]=true;
			}
		}
		
		int count=0;
		for(int i=0;i<max-min+1;i++) {
			if(!check[i])
				count++;
		}
		
		System.out.println(count);
	}

}
