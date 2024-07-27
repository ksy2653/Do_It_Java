package extra.Q1181;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	//첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 
	//둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/extra/Q1181/input.txt"));

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<String>[] list = new ArrayList[51];
		for(int i=1;i<=50;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			String word = sc.next();
			int word_len = word.length();
			if(!list[word_len].contains(word))
				list[word_len].add(word);
		}
		
		for(int i=1;i<=50;i++) {
			if(list[i].isEmpty())
				continue;
			Collections.sort(list[i]);
			for(int j=0;j<list[i].size();j++) {
				System.out.println(list[i].get(j));
			}
		}
	}

}
