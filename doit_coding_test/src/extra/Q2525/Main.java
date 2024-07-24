package extra.Q2525;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	// 첫째 줄에는 현재 시각이 나온다. 현재 시각은 시 A (0 ≤ A ≤ 23) 와 분 B (0 ≤ B ≤ 59)가 정수로 빈칸을 사이에 두고 순서대로 주어진다. 
	//두 번째 줄에는 요리하는 데 필요한 시간 C (0 ≤ C ≤ 1,000)가 분 단위로 주어진다.
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/extra/Q2525/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int cooking_hour = C/60;
		int cooking_minute = C%60;
		
		int hour = A + cooking_hour;
		int minute = B + cooking_minute;
		
		hour = (hour + (minute/60)) % 24;
		minute = minute%60;
		
		System.out.println(hour + " " + minute);

	}

}

// 첫째 줄에는 현재 시각이 나온다. 현재 시각은 시 A (0 ≤ A ≤ 23) 와 분 B (0 ≤ B ≤ 59)가 정수로 빈칸을 사이에 두고 순서대로 주어진다. 
//두 번째 줄에는 요리하는 데 필요한 시간 C (0 ≤ C ≤ 1,000)가 분 단위로 주어진다.
