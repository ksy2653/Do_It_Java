package programmers.서울에서_김서방_찾기;


class Solution {
    public static String solution(String[] seoul) {
    	String answer = "";
        for(int i=0;i<seoul.length;i++) {
        	if(seoul[i].equals("Kim")) {
        		answer = "김서방은 " + i + "에 있다";
        		break;
        	}
        }
                
        return answer;
    }
    
    public static void main(String[] args) {
    	String[] seoul = {"Jane", "Kim"};
    	System.out.println(solution(seoul));
    }
}
