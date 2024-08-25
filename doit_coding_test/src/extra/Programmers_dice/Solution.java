import java.util.*;

class Solution {
    int[][] Dice;
    int[] answer;
    int DiceLength;
    
    ArrayList<int[]> combA = new ArrayList<int[]>();
    ArrayList<int[]> combB = new ArrayList<int[]>();
    
    ArrayList<Integer> scoreA = new ArrayList<Integer>();
    ArrayList<Integer> scoreB = new ArrayList<Integer>();
    
    int maxWinCnt = 0;
    public int[] solution(int[][] dice) {
        Dice = dice;
        DiceLength = dice.length;
        
        getComb(0, 0, new int[DiceLength / 2]);
 
		//A가 뽑는 모든 조합에 대해서 주사위 점수를 비교합니다.
        //이떄 중복되서 계산하는 부분이 있습니다만, 시간초과는 발생하지 않습니다.
        for(int i=0;i<combA.size()/2;i++){
            int[] combAStore = combA.get(i);
            
            boolean[] visited = new boolean[DiceLength];
            for(int j=0; j<combAStore.length; j++){
                visited[combAStore[j]] = true;
            }
            
            int[] combBStore = new int[DiceLength / 2];
            int combBStoreIdx = 0;
            for(int j=0;j<DiceLength; j++){
                if(visited[j] == false){
                    combBStore[combBStoreIdx++] = j;
                }
            }
            scoreA.clear(); scoreB.clear();
            calculateScore(0, 0, combAStore, scoreA);
            calculateScore(0, 0, combBStore, scoreB);
            
            Collections.sort(scoreA);
            Collections.sort(scoreB);
            int localWinCnt = 0;
            
            for(int j=0;j<scoreA.size();j++){
                //잘못 계산한경우이다. 이긴경우를 더해야합니다.
                // localWinCnt += scoreA.size() - binarySearch(0, scoreA.size() - 1, scoreB, scoreA.get(j)) + 1;
                localWinCnt += binarySearch(0, scoreA.size() - 1, scoreB, scoreA.get(j)) + 1;
                // System.out.println();
            }
            
            if(maxWinCnt < localWinCnt){
                maxWinCnt = localWinCnt;
                answer = combAStore.clone();
            }
            
            localWinCnt = 0;
            for(int j=0;j<scoreB.size();j++){
                //잘못 계산한경우이다. 이긴경우를 더해야합니다.
                // localWinCnt += scoreA.size() - binarySearch(0, scoreA.size() - 1, scoreB, scoreA.get(j)) + 1;
                localWinCnt += binarySearch(0, scoreA.size() - 1, scoreA, scoreB.get(j)) + 1;
            }
            if(maxWinCnt < localWinCnt){
                maxWinCnt = localWinCnt;
                answer = combBStore.clone();
            }
            
        }
        
        for(int i=0;i<DiceLength/2;i++){
            answer[i] += 1;
        }
        return answer;
    }
    
    
public int binarySearch(int start, int end, ArrayList<Integer> arr, int targetNum){
        
        int left = 0, right = end;
        
        while(left <= right){
            int middle = (left + right) / 2;
            //만약 목표 num이 더 작은 경우에도 right = middle - 1 로 처리하여 해당 숫자가 질 수 있는 경우의 수를 구한다.
            if(targetNum <= arr.get(middle)){
                right = middle - 1;          
            } else if(targetNum > arr.get(middle)){
                left = middle + 1;
            }
        }
        return right;
    }
    
    public void calculateScore(int level, int sum, int[] selectedDice, ArrayList<Integer> Target){
        if(level == DiceLength / 2){
            Target.add(sum);
            return ;
        }
        for(int i=0;i<6;i++){
            calculateScore(level + 1, sum + Dice[selectedDice[level]][i], selectedDice, Target);
        }
        
    }
    
    public void getComb(int level, int idx, int[] selected){
        //절반을 선택했다면,
        if(level == DiceLength / 2){
            combA.add(selected.clone());
            // combA.add(selected); 배열은 참조값으로 들어가기에 clone을 해주어야합니다.
            return ;
        }
        
        for(int i = idx; i < DiceLength; i++){
            selected[level] = i;
            getComb(level + 1, i + 1, selected);
            selected[level] = 0;
        }
    }
}