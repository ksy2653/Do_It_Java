package programmers.영어_끝말잇기;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer;

        Map<String,Integer> map = new HashMap<>();
        
        int fail = 0;
        map.put(words[0],1);
        for(int i=1;i<words.length;i++){
            String before = words[i-1];
            String now = words[i];
            
            if(now.charAt(0) != before.charAt(before.length()-1) || map.containsKey(now)){
                fail=i;
                break;
            }
            else{
                map.put(now,1);
            }
        }
        
        if(fail==0)
            answer = new int[]{0,0};

        else{
            int failMember=0;
            int failOrder=0;
            
            if((fail+1)%n !=0){
                failMember = (fail+1)%n;
                failOrder = (fail+1)/n + 1;
            }
            else{
                failMember = n;
                failOrder = (fail+1)/n;
            }
            
            answer = new int[]{failMember,failOrder};
        }
        return answer;
    }
}
