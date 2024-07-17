package ch06.Q1541;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch06/Q1541/input.txt"));

		Scanner sc = new Scanner(System.in);
		String line = sc.next();
		
		String[] num = line.split("-");
		int sum=0;
		
		for(int i=0;i<num.length;i++) {
			if(i==0)
				sum = sum + mySum(num[i]);
			else
				sum = sum - mySum(num[i]);
		}
		
		System.out.println(sum);
	}
	
	public static int mySum(String num) {
		String temp[] = num.split("[+]");
		int sum=0;
		
		for(int i=0;i<temp.length;i++) {
			sum = sum + Integer.parseInt(temp[i]);
		}
		
		return sum;
	}

}