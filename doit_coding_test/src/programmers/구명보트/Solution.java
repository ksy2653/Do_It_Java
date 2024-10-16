package programmers.구명보트;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int leftIndex=0;
        int rightIndex=people.length-1;

        while(leftIndex<rightIndex){
            
            if(people[leftIndex]+people[rightIndex] <= limit){
                answer++;
                rightIndex--;
                leftIndex++;
            }
            else{
                answer++;
                rightIndex--;
            }
        }
        
        if(leftIndex==rightIndex)
            return answer+1;
        else
            return answer;
    }
}
