package extra.Q11650;

import java.io.FileInputStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static PriorityQueue<Point> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/extra/Q11650/input.txt"));

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0;i<N;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			pq.add(new Point(x,y));
		}
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			System.out.println(cur.x + " " + cur.y);
		}
	}

}

class Point implements Comparable<Point>{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(Point p) {
		if(x != p.x)
			return x - p.x;
		else
			return y - p.y;
	}
}
