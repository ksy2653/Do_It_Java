package main;

import java.io.BufferedReader;	
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		String dic[] = new String[n];
		for(int i=0;i<n;i++) {
			dic[i] = sc.next();
		}
		
		int count=0;
		for(int i=0;i<m;i++) {
			String text = sc.next();
			for(int j=0;j<n;j++) {
				if(dic[j].equals(text)) {
					count++;
					break;
				}
			}
		}
		
		System.out.println(count);
			
	}
	
}