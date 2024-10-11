package programmers.과제_진행하기;

import java.util.*;

class Solution {
    public List<String> solution(String[][] plans) {
        int len = plans.length;
        List<String> answer = new ArrayList<>();
        PriorityQueue<Assignment> pq = new PriorityQueue<>();
        
        for(int i=0;i<len;i++){
            String name = plans[i][0];
            
            String[] start_time = plans[i][1].split(":");
            int hour = Integer.parseInt(start_time[0]);
            int minute = Integer.parseInt(start_time[1]);
            int start = hour*60+minute;
            
            int playtime = Integer.parseInt(plans[i][2]);
            
            pq.add(new Assignment(name,start,playtime));
        }
        
        Stack<Assignment> stack = new Stack<>();
        
        while(!pq.isEmpty()){
            Assignment current = pq.poll();
            String name = current.name;
            int start = current.start;
            int playtime = current.playtime;
            
            int Time = start;
            
            // 다음 과제가 존재할 때
            if(!pq.isEmpty()){
                Assignment next = pq.peek();
                //다음 과제 전에 과제를 끝낼 때
                if(Time + playtime <= next.start){
                    answer.add(name);
                    Time += playtime;
                    
                    // 중단된 과제가 존재할 때
                    while(!stack.isEmpty()){
                        Assignment stop = stack.pop();
                        if(Time + stop.playtime <= next.start){
                            answer.add(stop.name);
                            Time += stop.playtime;
                        }
                        else{
                            stack.push(new Assignment(stop.name,stop.start,(stop.playtime-next.start+Time)));
                            break;
                        }
                    }
                }
                //다음 과제 전에 과제를 못 끝낼 때
                else{
                    stack.push(new Assignment(name,start,(playtime-next.start+Time)));
                }    
            }
            // 다음 과제가 없을 때
            else{
                answer.add(name);
                // 중단된 과제 마무리
                while(!stack.isEmpty()){
                    answer.add(stack.pop().name);
                }
            }
        }
        return answer;
    }
}

class Assignment implements Comparable<Assignment>{
    String name;
    int start;
    int playtime;
    
    public Assignment(String name, int start, int playtime){
        this.name=name;
        this.start=start;
        this.playtime=playtime;
    }
    
    public int compareTo(Assignment a){
        return this.start - a.start;
    }
}
