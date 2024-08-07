package ch07.Q1747;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] prime = new int[10000001];
		
		for(int i=2;i<=1000000;i++) {
			prime[i]=i;
		}
		
		for(int i=2;i<Math.sqrt(10000001);i++) {
			if(prime[i]==0)
				continue;
			for(int j=i*2;j<=10000000;j=j+i) {
				prime[j]=0;
			}
		}
		
		int temp=N;
		while(true) {
			if(prime[temp] !=0 && isPalindrome(temp)) {
				System.out.println(temp);
				break;
			}
			temp++;
		}

	}
	
	public static boolean isPalindrome(int num) {
//		String strNum = String.valueOf(num);
//		if(strNum.length() % 2 ==0) {
//			for(int i=0;i<strNum.length()/2;i++) {
//				if(strNum.charAt(i) != strNum.charAt(strNum.length()-1-i)) {
//					return false;
//				}
//			}
//			return true;
//		}
//		
//		else {
//			for(int i=0;i<strNum.length()/2;i++) {
//				if(strNum.charAt(i) != strNum.charAt(strNum.length()-1-i)) {
//					return false;
//				}
//			}
//			return true;
//		}
		
		char temp[] = String.valueOf(num).toCharArray();
		int s=0;
		int e=temp.length-1;
		
		while(s<e) {
			if(temp[s] != temp[e])
				return false;
			s++;
			e--;
		}
		return true;
	}

}
