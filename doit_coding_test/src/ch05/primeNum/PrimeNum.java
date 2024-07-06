package ch05.primeNum;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNum {
	static int N;
	static ArrayList<Integer> primeList;

	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src/ch05/primeNum/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		primeList = new ArrayList<>();
		
		dfs(2,1);
		dfs(3,1);
		dfs(5,1);
		dfs(7,1);
		
		for(int i=0;i<primeList.size();i++) {
			System.out.println(primeList.get(i));
		}
	}
	
	public static boolean isPrime(int num) {
		if(num<=1) 
			return false;
		if(num==2)
			return true;
		for(int i=2;i<num;i++) {
			if(num%i == 0)
				return false;
		}
		
		return true;
	}

	public static void dfs(int i, int jarisu) {
		if(jarisu == N)
			primeList.add(i);
		for(int j=1;j<=9;j+=2) {
			int temp = 10*i+j;
			if(isPrime(temp))
				dfs(temp,jarisu+1);
		}
	}
}
