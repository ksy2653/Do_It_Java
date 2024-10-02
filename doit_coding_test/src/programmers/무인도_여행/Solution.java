package programmers.무인도_여행;

import java.util.*;

class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited;
    static int[][] map;
    static int row,col,food;
    
    public int[] solution(String[] maps) {
        row = maps.length;
        col = maps[0].length();
        
        visited = new boolean[row][col];
        map = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(maps[i].charAt(j) == 'X'){
                    map[i][j] = 0;
                }
                else
                    map[i][j] = maps[i].charAt(j) - '0';
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
                
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visited[i][j] && map[i][j] != 0){
                    food=map[i][j];
                    dfs(i,j);
                    list.add(food);
                }
                
            }
        }
        if(list.size()==0){
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);       
        }
        Arrays.sort(answer);
        
        return answer;
    }
    
    public static void dfs(int x, int y){
        if(visited[x][y])
            return;
        
        visited[x][y] = true;
        
        for(int i=0;i<4;i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if(0<=newX && newX<row && 0<=newY && newY <col 
               && map[newX][newY] != 0 && !visited[newX][newY]) {
                
                food += map[newX][newY];
                dfs(newX,newY);
            }
        }
    }
}
