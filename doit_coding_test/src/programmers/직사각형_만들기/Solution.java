package programmers.직사각형_만들기;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		int[][] v = {{1,1},{2,2},{1,2}};
		int[] ans = solution(v);
		
		int x = ans[0];
		int y = ans[1];

		System.out.println(x + "ddd" + y);
	}
	
	public static int[] solution(int[][] v) {
		
		Map<Integer,Integer> map_x = new HashMap<>();
		Map<Integer,Integer> map_y = new HashMap<>();
		for(int i=0;i<3;i++) {
			int x = v[i][0];
			int y = v[i][1];
			
			map_x.put(x, map_x.getOrDefault(x, 0)+1);
			map_y.put(y, map_y.getOrDefault(y, 0)+1);
		}
		
		int ans_x = 0;
		int ans_y = 0;
		
		for(int i=0;i<3;i++) {
			int x = v[i][0];
			int y = v[i][1];
			
			if(map_x.get(x)==1)
				ans_x = x;
			if(map_y.get(y)==1)
				ans_y=y;
		}
		
		int[] answer = {ans_x,ans_y};
		
		return answer;
	}

}
