package extra.Q1764;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/extra/Q1764/input.txt"));

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		HashSet<String> set = new HashSet<>(); 
        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }
		
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			String temp = sc.next();
			if(set.contains(temp))
				list.add(temp);
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

}
