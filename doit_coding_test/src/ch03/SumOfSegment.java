package ksy2653.doit_coding_test.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfSegment {
    // 11659번 백준
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        /* JAVA에서 사용자로부터 값을 받아오는 방법은 Scanner와 BufferedReader 2가지가 있다
         * Scanner는 느리고, BufferedReader는 빨라서 대용량 처리하는데 용이
         * BufferedReader를 사용하면 예외처리를 해줘야한다.
         * StringTokenizer는 String을 Token화함 -> 식별자가 없으면 띄어쓰기로 토큰화
         */

        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());
        long[] S = new long[suNo+1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i=1;i<=suNo;i++) {
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int q=0; q<quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i-1]);
        }
    }

}