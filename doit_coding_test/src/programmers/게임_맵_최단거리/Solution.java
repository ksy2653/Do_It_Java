package programmers.게임_맵_최단거리;

import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n+1][m+1];
        int[][] distance = new int[n+1][m+1];
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,1});
        visited[1][1] = true;
        distance[1][1] = 1;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            
            for(int i=0;i<4;i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                if(0<newX && newX <=n && 0<newY && newY <=m &&
                  maps[newX-1][newY-1] == 1 && visited[newX][newY] == false){
                    
                    visited[newX][newY] = true;
                    distance[newX][newY] = distance[x][y] + 1;
                    queue.add(new int[]{newX,newY});
                }
            }
        }
        if(distance[n][m] == 0)
            return -1;
        
        return distance[n][m];
    }
}