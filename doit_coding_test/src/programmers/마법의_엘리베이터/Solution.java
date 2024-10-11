package programmers.마법의_엘리베이터;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey!=0){
            int last = storey % 10;
            int second = (storey/10) % 10;

            if(last < 5){
                answer += last;
            }
            else if(last>5){
                storey = storey + 10 - last;
                answer = answer + 10 - last;
            }
            else{
                if(second <5){
                    answer += last;
                }
                else{
                    storey = storey + 10 - last;
                    answer = answer + 10 - last;
                }
            }
                
            
            storey /= 10;
        }
        
        return answer;
    }
}
