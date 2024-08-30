package ch09.Q14425;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch09/Q14425/input.txt"));

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		tNode root = new tNode();
		
		while(n>0) {
			String text = sc.next();
			tNode now = root;
			for(int i=0;i<text.length();i++) {
				char c = text.charAt(i);
				if(now.next[c - 'a'] == null)
					now.next[c-'a'] = new tNode();
				
				now = now.next[c-'a'];
				if(i==text.length()-1)
					now.isEnd = true;
			}
			
			n--;
		}
		
		int count=0;
		while(m>0) {
			String text = sc.next();
			tNode now = root;
			for(int i=0;i<text.length();i++) {
				char c = text.charAt(i);
				if(now.next[c-'a'] == null)
					break;
				now = now.next[c-'a'];
				
				if(i == text.length() - 1 && now.isEnd)
					count++;
			}
			
			m--;
		}
		
		System.out.println(count);
		
	}

}

class tNode{
	tNode[] next = new tNode[26];
	boolean isEnd;
}
