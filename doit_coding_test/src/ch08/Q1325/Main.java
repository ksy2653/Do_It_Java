package ch08.Q1325;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int computer, edge;
    static ArrayList<Integer> trust[];
    static int[] hacking;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/ch08/Q1325/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        computer = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        trust = new ArrayList[computer + 1];
        hacking = new int[computer + 1];

        for (int i = 1; i <= computer; i++) {
            trust[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            trust[s].add(e);
        }

        int max = 0;

        for (int i = 1; i <= computer; i++) {
            visited = new boolean[computer + 1];
            bfs(i);
        }
        
        for(int i=1;i<=computer;i++) {
        	max = Math.max(max, hacking[i]);
        }

        for (int i = 1; i <= computer; i++) {
            if (hacking[i] == max) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void bfs(int Node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Node);
        visited[Node] = true;

        while (!queue.isEmpty()) {
            int now_Node = queue.poll();
            for (int i : trust[now_Node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    hacking[i]++;
                }
            }
        }

    }
}
