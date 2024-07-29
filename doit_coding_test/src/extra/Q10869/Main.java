package extra.Q10869;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	//두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오. 
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src/extra/Q10869/input.txt"));

		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.println(A+B);
		System.out.println(A-B);
		System.out.println(A*B);
		System.out.println(A/B);
		System.out.println(A%B);
	}

}
