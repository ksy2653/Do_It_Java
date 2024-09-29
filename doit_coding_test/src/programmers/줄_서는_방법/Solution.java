package programmers.줄_서는_방법;

public class Solution {

	public static void main(String[] args) {
		int[] ans = new int[3];
		ans = solution(3,5);
		
		System.out.println(ans);

	}
	
	public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        long[] F = new long[21];
        boolean[] visited = new boolean[21];
        
        F[0]=1;
        for(int i=1;i<=n;i++) {
        	F[i] = F[i-1] * i;
        }
        
        for(int i=1;i<=n;i++) {
        	for(int j=1,cnt=1;j<=n;j++) {
        		if(visited[j])
        			continue;
        		if(k<=cnt*F[n-i]) {
        			k -= (cnt-1) * F[n-i];
        			answer[i-1]=j;
        			visited[j]=true;
        			break;
        		}
        		
        		cnt++;
        	}
        }
        
        return answer;
    }

}
// n=3,k=5 -> output: [3,1,2]

// n은 20이하의 자연수 입니다.
// k는 n! 이하의 자연수 입니다.