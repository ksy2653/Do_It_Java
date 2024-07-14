package ch05.Q1300;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch05/Q1300/input.txt"));

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		long start = 1;
		long end = k;
		while(start<=end) {
			long mid = (start+end)/2;
			long count=0;
			for(int i=1;i<=n;i++) {
				long num = mid / i;
				count += Math.min(num, n);
			}
			
			if(count == k) {
				start = mid;
				break;
			}
			
			else if(count > k)
				end = mid-1;
			else
				start = mid+1;
		}
		
		System.out.println(start);
	}

}

/*
 * n,k 입력
 * start = 1, end = k
 * count++ for문에서 초기화하면서 돌리기 
 */
