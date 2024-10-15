package programmers.짝지어_제거하기;

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        char[] S = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(S[0]);
        for(int i=1;i<S.length;i++){
            if(stack.isEmpty())
                stack.push(S[i]);
            else if(stack.peek() == S[i])
                stack.pop();
            else
                stack.push(S[i]);
                     
         }
        
        if(stack.isEmpty())
            answer = 1;
        else
            answer = 0;
        
        

        return answer;
    }
}
