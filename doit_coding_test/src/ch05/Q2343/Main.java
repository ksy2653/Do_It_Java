package ch05.Q2343;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch05/Q2343/input.txt"));

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] lecture = new int[N];
		for (int i = 0; i < N; i++) {
			lecture[i] = sc.nextInt();
		}
		
		int max = lecture[0];
		int sum=0;
		for (int i = 0; i < N; i++) {
			if(max < lecture[i])
				max = lecture[i];
			sum+=lecture[i];
		}
		
		int left = max;
		int right = sum;
		while(left<=right) {
			int count=0;
			int length = 0;
			int mid = (left+right)/2;
			
			for (int i = 0; i < N; i++) {
				if(length + lecture[i] > mid) {
					count++;
					length=0;
				}
				length += lecture[i];
			}
			
			if(length !=0)
				count++;
			if(count>M)
				left = mid + 1;
			else
				right = mid-1;
		}
		
		System.out.println(left);
	}

}

/*
 * N M 입력 받기
 * list 배열 만들어서 넣기
 * list 최댓값과 총 합 구하기 -> max, sum -> 초기 binary search의 left, right 설정
 * while 문으로 가보자 -> count == M 일 때 if문 돌려서 ㅇㅋ 
*/
