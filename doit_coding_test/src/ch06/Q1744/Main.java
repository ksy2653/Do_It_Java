package ch06.Q1744;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch06/Q1744/input.txt"));

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		PriorityQueue<Integer> minusPq = new PriorityQueue<>();
		PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
		int zero=0;
		int one=0;
		
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			if(num<0)
				minusPq.add(num);
			else if(num==0)
				zero++;
			else if(num==1)
				one++;
			else
				plusPq.add(num);
		}
		
		int sum=0;
		while(plusPq.size()>1) {
			int first = plusPq.poll();
			int second = plusPq.poll();
			sum += first*second;
		}
		
		if(!plusPq.isEmpty())
			sum+=plusPq.poll();
		
		
		while(minusPq.size()>1) {
			int first = minusPq.poll();
			int second = minusPq.poll();
			sum += first*second;
		}
		
		if(!minusPq.isEmpty()) {
			if(zero==0) {
				sum+=minusPq.poll();
			}
		}
		
		sum = sum + one;
		
		System.out.println(sum);
	}

}

/*
 * 양수 -> 큰 수 2개씩 곱해야 함
 * 음수 -> 2개 이상이면 작은 값들 끼리 곱해야 함
 *    -> 남은게 1개면 0이 있으면 0이랑 곱하기, 없으면 더하기
 *  0 -> 음수 있으면 곱하기 없으면 더하기
 *  
 *  
 *  구현단계
 *  우선순위 큐 -> pop시켜야겠다 -> 
*/
