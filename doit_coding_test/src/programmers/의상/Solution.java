package programmers.의상;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> map = new HashMap<>();
        int cloth_cate=0;
        for(int i=0;i<clothes.length;i++){
            String cate = clothes[i][1];
            
            map.put(cate, map.getOrDefault(cate, 0)+1);
        }
        
        for (Integer value : map.values()){
            answer *= value + 1;
        }

        return answer - 1;
    }
}

