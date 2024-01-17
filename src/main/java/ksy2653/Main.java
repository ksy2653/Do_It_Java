package ksy2653;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S[] = new int[N];
        for(int i=0;i<N;i++){
            S[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(S);

        int count=0;
        int start_index=0;
        int end_index=N-1;
        while (end_index > start_index){
            int sum = S[start_index] + S[end_index];
            if (sum == M){
                count++;
                start_index++;
                end_index--;
            }
            else if (sum > M)
                end_index--;
            else
                start_index++;
        }

        System.out.print(count);
        bf.close();
    }
}