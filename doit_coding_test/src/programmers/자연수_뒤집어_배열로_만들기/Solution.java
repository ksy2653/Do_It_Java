package programmers.자연수_뒤집어_배열로_만들기;

import java.util.*;

class Solution {
    public long[] solution(long n) {
        
        List<Long> ans = new ArrayList<>();
        while(n!=0){
            long tmp = n%10;
            ans.add(tmp);
            n/=10;
        }
        
        long[] answer = new long[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
