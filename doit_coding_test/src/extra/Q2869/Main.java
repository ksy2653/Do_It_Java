package extra.Q2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long V = Long.parseLong(st.nextToken());
		
		long oneday_move=A-B;
		long day=0;
		
		if((V-A)%oneday_move == 0) {
			day = (V-A)/oneday_move + 1;
		}
		else
			day = (V-A)/oneday_move + 2;
		
		System.out.println(day);

	}

}
