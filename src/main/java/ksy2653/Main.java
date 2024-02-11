package ksy2653;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();

        int[] A = new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        Arrays.sort(A);

        System.out.print(A[k-1]);


    }
}