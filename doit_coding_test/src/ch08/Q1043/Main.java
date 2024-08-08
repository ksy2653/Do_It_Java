package ch08.Q1043;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        // Input handling
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i; // Initialize each person's representative node to itself
        }

        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken());
        if(truthNum==0) {
			System.out.println(M);
			return;
		}
        int[] truthPeople = new int[truthNum];
        for (int i = 0; i < truthNum; i++) {
            truthPeople[i] = Integer.parseInt(st.nextToken());
        }

        // Read all parties
        Party[] parties = new Party[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int numOfPeople = Integer.parseInt(st.nextToken());
            int[] list = new int[numOfPeople];
            for (int j = 0; j < numOfPeople; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }
            parties[i] = new Party(numOfPeople, list);

            // Union the people in the same party
            for (int j = 1; j < numOfPeople; j++) {
                union(list[0], list[j]);
            }
        }

        // Union all truth known people
        for (int i = 1; i < truthNum; i++) {
            union(truthPeople[0], truthPeople[i]);
        }

        // Check each party if it can be lied
        int count = 0;
        for (int i = 0; i < M; i++) {
            boolean canLie = true;
            for (int person : parties[i].list) {
                if (find(person) == find(truthPeople[0])) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}

class Party {
    int numOfPeople;
    int[] list;

    public Party(int numOfPeople, int[] list) {
        this.numOfPeople = numOfPeople;
        this.list = list;
    }
}
