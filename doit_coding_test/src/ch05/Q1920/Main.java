package ch05.Q1920;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int[] data_list, find_list;
	

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch05/Q1920/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		data_list = new int[N];
		for(int i=0;i<N;i++) {
			data_list[i] = sc.nextInt();
		}
		
		Arrays.sort(data_list);
		
		M = sc.nextInt();
		find_list = new int[M];
		for(int i=0;i<M;i++) {
			find_list[i] = sc.nextInt();
		}
		
		for(int i=0;i<M;i++) {
			binarySearch(0, data_list.length-1, find_list[i]);
		}
	}
	
	public static void binarySearch(int start, int end, int num) {
		if(start <= end) {
			int index = (start + end)/2;
			if(data_list[index] == num) {
				System.out.println(1);
				return;
			}
			
			if(data_list[index] < num) {
				start = index + 1;
				binarySearch(start,end,num);
				return;
			}
			else {
				end = index-1;
				binarySearch(start,end,num);
				return;
			}
		}
		System.out.println(0);
	}

}

/*
 * 정렬 -> 오름차순 정렬
 * 
 */
