package programmers.피로도;

class Solution {
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0,k,dungeons);
        
        return answer;
    }
    
    public static void dfs(int depth, int use, int[][] dungeons){
        for(int i=0;i<dungeons.length;i++){
            if(visited[i] || dungeons[i][0] > use)
                continue;
            else{
                visited[i] = true;  
                dfs(depth + 1, use - dungeons[i][1], dungeons);  
                visited[i] = false;  
            }
        }
        
        answer = Math.max(answer,depth);
    }
}

