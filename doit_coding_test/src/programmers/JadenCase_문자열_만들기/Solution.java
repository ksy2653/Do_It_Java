package programmers.JadenCase_문자열_만들기;

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] words = s.split(" ");
        for(int i=0;i<words.length;i++){
            String now = words[i];
            if(now.length()==0)
                answer += " ";
            else{
                answer += now.substring(0,1).toUpperCase();
                answer += now.substring(1,now.length()).toLowerCase();
                answer += " ";
            }
        }
        
        if(s.substring(s.length()-1,s.length()).equals(" "))
            return answer;
        else
            return answer.substring(0,answer.length()-1);
    }
}