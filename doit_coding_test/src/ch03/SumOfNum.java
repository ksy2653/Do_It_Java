package ksy2653.doit_coding_test.ch03;

import java.util.Scanner;

public class SumOfNum {
    // 11720번 백준
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();

        int sum=0;

        for (int i=0; i<cNum.length; i++) {
            sum +=cNum[i] - '0';
            // '0'의 ASCII 코드의 값을 빼준다.
            // ex) '3'의 ASCII 코드 값은 51이므로 '0'(48)을 빼줘서 3의 값을 sum에 저장
        }
        System.out.print(sum);
    }

}
