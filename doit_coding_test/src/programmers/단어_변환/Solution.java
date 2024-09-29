package programmers.단어_변환;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static ArrayList<String> list[];
	static String[] new_words;
	static boolean[] visited;
	static int depth=0;

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		int ans = solution(begin,target,words);
		
		System.out.println(ans);

	}

	public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        int length = words.length;
        int word_len = begin.length();
        
        visited = new boolean[length+1];
        new_words = new String[length+1];
        new_words[0] = begin;
        for(int i=1;i<=length;i++) {
        	new_words[i] = words[i-1];
        }
        
        list = new ArrayList[length+1];
        for(int i=0;i<=length;i++) {
        	list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<=length;i++) {
        	for(int j=0;j<=length;j++) {
        		int cnt=0;
        		for(int k=0;k<word_len;k++) {
        			if(new_words[i].charAt(k) == new_words[j].charAt(k))
        				cnt++;
        		}
        		
        		if(cnt == word_len-1)
        			list[i].add(new_words[j]);
        	}
        }
        
        answer = bfs(begin, target, new_words);
        
        return answer;
    }
	
	public static int bfs(String begin, String target, String[] new_words) {
		Queue<String> queue = new LinkedList<>();
		queue.add(begin);
		visited[0] = true;
		boolean isExist = false;
		int[] depth = new int[new_words.length];
		depth[0]=0;
		
		while(!queue.isEmpty()) {
			String now = queue.poll();
			int index = findIndex(now);
			for(String next:list[index]) {
				int new_index = findIndex(next);
				if(!visited[new_index]) {
					visited[new_index]=true;
					queue.add(next);
					depth[new_index] = depth[index] + 1;
				}
				
				if(next.equals(target)) {
					isExist = true;
					break;
				}
			}
			
		}
		
		if(isExist)
			return depth[findIndex(target)];
		else
			return 0;
	}
	
	public static int findIndex(String word) {
		int index = -1;
		for(int i=0;i<new_words.length;i++) {
			if(word.equals(new_words[i]))
				index=i;
		}
		
		return index;
	}
}

/*
 * 각 단어는 알파벳 소문자로만 이루어져 있습니다.
 * 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
 * words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
 * begin과 target은 같지 않습니다.
 * 변환할 수 없는 경우에는 0를 return 합니다.
 * "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	
 * 4
*/
