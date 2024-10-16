package programmers.N개의_최소공배수;

class Solution {
    public int solution(int[] arr) {
        if(arr.length==1)
            return arr[0];
        
        int answer = lcm(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            answer = lcm(answer,arr[i]);
        }
        return answer;
    }
    
    public static int gcd(int a, int b){
        if(b==0)
            return a;
        else
            return gcd(b,a%b);
    }
    
    public static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
}
