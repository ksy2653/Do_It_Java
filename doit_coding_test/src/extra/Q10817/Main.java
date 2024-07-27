package extra.Q10817;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/extra/Q10817/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int[] list = {A,B,C};
		
		for(int i=0;i<2;i++) {
			for(int j=i+1;j<3;j++) {
				if(list[i] > list[j]) {
					int temp=list[i];
					list[i]=list[j];
					list[j]=temp;
				}
			}
		}
		
		System.out.println(list[1]);

	}

}
