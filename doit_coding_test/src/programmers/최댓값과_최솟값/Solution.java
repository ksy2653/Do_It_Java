package programmers.최댓값과_최솟값;

public class Solution {

	public static void main(String[] args) {
		String list = "1 2 3 4";
		String ans = solution(list);
		
		System.out.println(ans);

	}
	
	public static String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        String[] list = s.split(" ");
        for(int i=0;i<list.length;i++) {
        	if(min > Integer.parseInt(list[i]))
        		min = Integer.parseInt(list[i]);
        	if(max < Integer.parseInt(list[i]))
        		max = Integer.parseInt(list[i]);
        }
        
        answer = min + " " + max;
        
        return answer;
    }

}

//input: "1 2 3 4"	
//output: "1 4"