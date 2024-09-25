package programmers.소수_찾기;


public class Solution {

	public static void main(String[] args) {
		int result = solution(10);
		
		System.out.println(result);

	}

	 public static int solution(int n) {
	        int answer = 0;
	        int prime[] = new int[n+1];
	        for(int i=2;i<=n;i++) {
	        	prime[i]=i;
	        }
	        
	        for(int i=2;i<=Math.sqrt(n);i++) {
	        	if(prime[i]==0)
	        		continue;
	        	for(int j=i*2;j<=n;j=j+i) {
	        		prime[j]=0;
	        	}
	        }
	        
	        for(int i=2;i<=n;i++) {
	        	if(prime[i]!=0)
	        		answer++;
	        }
	        
	        return answer;
	}
}

//n은 2이상 1000000이하의 자연수입니다.
