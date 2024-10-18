package programmers.할인행사;

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<want.length;i++){
            map.put(want[i],number[i]);
        }
        
        for(int i=0;i<discount.length-9;i++){
            Map<String,Integer> mart = new HashMap<>();
            for(int j=i;j<i+10;j++){
                mart.put(discount[j],mart.getOrDefault(discount[j],0)+1);
            }
            
            boolean isWant = true;
            for(int j=0;j<want.length;j++){
                if(map.get(want[j]) != mart.get(want[j])){
                    isWant = false;
                    break;
                }
            }
            
            if(isWant)
                answer++;
        }
        
        return answer;
    }
}
