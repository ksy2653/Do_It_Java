package ch03;

import java.util.*;

public class Card {
    public static void main(String[] args){
        // 2164번 백준
        Scanner sc = new Scanner(System.in);
        Queue<Integer> myQueue = new LinkedList<>();
        int N = sc.nextInt();
        for(int i=1;i<=N;i++){
            myQueue.add(i);
        }

        while(myQueue.size() > 1){
            myQueue.poll(); // 맨 위의 카드를 버림
            myQueue.add(myQueue.poll()); // 맨 위의 카드를 가장 아래 카드 밑으로 이동
        }

        System.out.println(myQueue.poll()); // 마지막으로 남은 카드 출력
    }
}
