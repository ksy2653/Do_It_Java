package groom.카드_모으기;

import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		boolean[] num = new boolean[N+1];
		int card=0;
		for(int i=1;i<=M;i++){
			int card_num = sc.nextInt();
			if(!num[card_num]){
				num[card_num] = true;
				card++;
			}
			
			if(card == N){
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(-1);
	}
}