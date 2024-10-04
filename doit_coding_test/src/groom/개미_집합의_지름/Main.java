package groom.개미_집합의_지름;

import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] P = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(P);
		
    int begin = 0, end = 0;
    int maxAnts = 0;

    // 슬라이딩 윈도우 방식으로 최대 그룹의 개미 수 찾기
    while (begin < N && end < N) {
        int length = P[end] - P[begin];  // 현재 구간의 최대 길이
        int numOfAnts = end - begin + 1; // 현재 구간에 포함된 개미의 수

			  if (length <= D) {  // 최대 길이가 D 이하이면
            maxAnts = Math.max(maxAnts, numOfAnts);  // 최대 개미 수 갱신
            end++;  // end 포인터 확장
        } else {
            begin++;  // 구간이 길면 begin 포인터 이동
        }
    }

    System.out.println(N - maxAnts);  // 전체 개미 수 - 최대 그룹 개미 수
	}
}
