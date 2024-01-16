package ksy2653;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] S = new int[N];
        int[] C = new int[M];
        S[0] = sc.nextInt();

        for(int i=1;i<N;i++){
            S[i] = S[i-1] + sc.nextInt();
        }
        int answer=0;
        for(int i=0;i<N;i++){
            int remainder = (int) (S[i] % M);
            if(remainder ==0)
                answer++;
            C[remainder]++;
        }

        for(int i=0;i<M;i++){
            if(C[i]>1)
                answer = answer + (C[i]*(C[i]-1))/2;
        }
        System.out.print(answer);
    }

}