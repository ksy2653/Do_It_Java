package programmers.기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {       
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        
        int cnt=1;
        for(int i=0;i<progresses.length;i++){
            int deploy = 0;
            if((100-progresses[i]) % speeds[i] == 0)
                deploy = (100-progresses[i]) / speeds[i];
            else
                deploy = (100-progresses[i]) / speeds[i] + 1;
            
            if(stack.isEmpty())
                stack.push(deploy);
            else{
                if(stack.peek() >= deploy){
                    cnt++;
                }
                else{
                    stack.pop();
                    stack.push(deploy);
                    queue.add(cnt);
                    cnt=1;
                }
            }
        }
        queue.add(cnt);
        
        
        int size = queue.size();
        int[] answer = new int[size];
        for(int i=0;i<size;i++){
            answer[i] = queue.poll();
        }
        
        return answer;
    }
}

