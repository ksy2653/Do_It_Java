package programmers.올바른_괄호;

public class Solution {

	public static void main(String[] args) {
		String test = "(()(";
		boolean ans = solution(test);
		
		System.out.println(ans);

	}
	
	static boolean solution(String s) {
        boolean answer = true;

        String[] temp = s.split("");
        int left=0;
        int right=0;
        for(int i=0;i<s.length();i++) {
        	if(temp[i].equals("(")) {
        		left++;
        	}
        	else
        		right++;
        	
        	if(left < right) {
        		answer = false;
        		break;
        	}
        }
        
        if(left != right)
        	answer = false;

        return answer;
    }

}

// 문자열 s의 길이 : 100,000 이하의 자연수
// 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.