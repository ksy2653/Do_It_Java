package programmers.핸드폰_번호_가리기;

public class Solution {

	public static void main(String[] args) {
		String phone = "01033334444";
		String answer = solution(phone);
		
		System.out.println(answer);

	}

	public static String solution(String phone_number) {
        String answer = "";
        
        int length = phone_number.length();
        for(int i=0;i<length;i++) {
        	if(i<length-4)
        		answer += "*";
        	else
        		answer += phone_number.charAt(i);
        }
        
        return answer;
    }
}
