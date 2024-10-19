package programmers.괄호회전하기;

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int len = s.length();

        for (int i = 0; i < len; i++) {
            // 회전시키기: i번째부터 끝까지 + 처음부터 i번째까지
            String rotated = s.substring(i) + s.substring(0, i);
            
            if (isRight(rotated)) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isRight(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false; // 짝이 맞지 않는 경우
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false; // 괄호 짝이 맞지 않음
                }
            }
        }

        return stack.isEmpty(); // 모든 괄호를 처리한 후 스택이 비어 있어야 유효함
    }
}
