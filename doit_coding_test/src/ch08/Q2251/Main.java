package ch08.Q2251;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int maxA,maxB,maxC;
	static ArrayList<Integer> answer;
	static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ch08/Q2251/input.txt"));

		Scanner sc = new Scanner(System.in);
		maxA = sc.nextInt();
		maxB = sc.nextInt();
		maxC = sc.nextInt();
		
		answer = new ArrayList<>();
		
		bfs();
		
		Collections.sort(answer);
		for(int ans:answer) {
			System.out.print(ans + " ");
		}
	}
	
	public static void bfs() {
		Queue<Bottle> queue = new LinkedList<>();
		visited = new boolean[maxA+1][maxB+1][maxC+1];
		queue.add(new Bottle(0,0,maxC));
		
		while(!queue.isEmpty()) {
			Bottle current = queue.poll();
			if(visited[current.a][current.b][current.c])
				continue;
			visited[current.a][current.b][current.c] = true;
			
			if(current.a==0)
				answer.add(current.c);
			
			// move water C -> A
			if(current.c + current.a > maxA) {
//				current.a=maxA;
//				current.c=current.c - (maxA - current.a);
				queue.add(new Bottle(maxA,current.b,(current.c - (maxA - current.a))));
			}
			else {
//				current.a = current.a + current.c;
//				current.c=0;
				queue.add(new Bottle((current.a + current.c),current.b,0));
			}
			
			// move water C -> B
			if(current.c + current.b > maxB) {
//				current.b=maxB;
//				current.c=current.c - (maxB - current.b);
				queue.add(new Bottle(current.a,maxB,(current.c - (maxB - current.b))));
			}
			else {
//				current.b = current.b + current.c;
//				current.c=0;
				queue.add(new Bottle(current.a,(current.b + current.c),0));
			}
			
			// move water B -> A
			if(current.b + current.a > maxA) {
				queue.add(new Bottle(maxA,(current.b-(maxA-current.a)),current.c));
			}
			else {
				queue.add(new Bottle((current.a+current.b),0,current.c));
			}
			
			// move water B -> C
			if(current.b + current.c > maxC) {
				queue.add(new Bottle(current.a,(current.b-(maxC-current.c)),maxC));
			}
			else {
				queue.add(new Bottle(current.a,0,(current.b+current.c)));
			}
			
			// move water A -> B
			if(current.a + current.b > maxB) {
				queue.add(new Bottle((current.a-(maxB-current.b)),maxB,current.c));
			}
			else {
				queue.add(new Bottle(0,(current.a+current.b),current.c));
			}
			
			// move water A -> C
			if(current.a + current.c > maxC) {
				queue.add(new Bottle((current.a-(maxC-current.c)),current.b,maxC));
			}
			else {
				queue.add(new Bottle(0,current.b,(current.a+current.c)));
			}
		}
	}

}

class Bottle{
	int a;
	int b;
	int c;
	
	public Bottle(int a, int b, int c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
}
