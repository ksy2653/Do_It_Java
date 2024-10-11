package programmers.미로_탈출;

import java.util.*;

class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static char[][] map;
    static int col,row;
    static int start_col,start_row;
    static int lever_col,lever_row;
    static boolean[][] visited;
    
    public int solution(String[] maps) {
        int answer=0;
        
        col = maps.length;
        row = maps[0].length();
        
        map = new char[col][row];
        for(int i=0;i<col;i++){
            char[] maze = maps[i].toCharArray();
            for(int j=0;j<row;j++){
                map[i][j] = maze[j];
                if(map[i][j] == 'S'){
                    start_col=i;
                    start_row=j;
                }
                if(map[i][j] == 'L'){
                    lever_col=i;
                    lever_row=j;
                }
            }
        }
        
        int distance1 = bfs(start_col,start_row,'L');
        int distance2 = bfs(lever_col,lever_row,'E');
        
        if(distance1 == -1 || distance2 == -1)
            answer = -1;
        else
            answer = distance1 + distance2;

        return answer;
    }
    
    public static int bfs(int c, int r, char target){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {c,r});
        visited = new boolean[col][row];
        visited[c][r] = true;
        int[][] distance = new int[col][row];
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for(int i=0;i<4;i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                if(newX>=0 && newX<col && newY>=0 && newY<row
                  && visited[newX][newY]==false){
                    if(map[newX][newY]==target){
                        distance[newX][newY] = distance[x][y]+1;
                        return distance[newX][newY];
                    }
                    if(map[newX][newY]!='X'){
                        visited[newX][newY]=true;
                        distance[newX][newY] = distance[x][y]+1;
                        queue.add(new int[] {newX,newY});
                    }
                }
            }
        }
        
        return -1;
    }
    
}
