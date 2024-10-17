package programmers.귤_고르기;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		int ans = solution(6,new int[]{1, 3, 2, 5, 4, 5, 2, 3});
		
		System.out.println(ans);
	}
	
	public static int solution(int k, int[] tangerine) {
		int answer=0;
		
		Map<Integer,Integer> map = new HashMap<>();
		for(int size:tangerine) {
			map.put(size,map.getOrDefault(size,0)+1);
		}
		
		List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list,(a,b)->b.getValue().compareTo(a.getValue()));
		
		int index=0;
		while(k>0) {
			if(list.get(index).getValue() >= k) {
				answer++;
				break;
			}
			else {
				k -= list.get(index).getValue();
				answer++;
				index++;
			}
		}
		
		return answer;
	}

}
