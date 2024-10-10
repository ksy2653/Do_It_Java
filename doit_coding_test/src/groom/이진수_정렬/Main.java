package groom.이진수_정렬;

import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int K = sc.nextInt();
//		
//		PriorityQueue<BinaryNum> pq = new PriorityQueue<>();
//		for(int i=0;i<N;i++){
//			int num = sc.nextInt();
//			int oneCount = Integer.bitCount(num);
//			pq.add(new BinaryNum(num,oneCount));
//		}
//		
//		for(int i=0;i<K-1;i++){
//			pq.poll();
//		}
//		
//		System.out.println(pq.poll().num);
		
		boolean[][] visited = new boolean[10][10];
		Arrays.fill(visited, true);
		System.out.println(visited[2][2]);
		
	}
}

class BinaryNum implements Comparable<BinaryNum>{
	int num;
	int oneCount;
	
	public BinaryNum(int num, int oneCount){
		this.num=num;
		this.oneCount = oneCount;
	}
	
	public int compareTo(BinaryNum bn){
		if(this.oneCount != bn.oneCount)
			return bn.oneCount-this.oneCount;
		else
			return bn.num-this.num;
	}
}