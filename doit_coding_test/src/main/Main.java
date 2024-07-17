package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/main/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Meeting> pq = new PriorityQueue<>(new Comparator<Meeting>() {
			@Override
			public int compare(Meeting m1, Meeting m2) {
				if(m1.getEnd() == m2.getEnd()) {
					return Integer.compare(m1.getStart(), m2.getStart());
				}
				
				return Integer.compare(m1.getEnd(), m2.getEnd());
			}
		});
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			pq.add(new Meeting(s,e));
		}
		
		int count=0;
		int lastEndTime=0;
		
		while(!pq.isEmpty()) {
			Meeting current = pq.poll();
			if(current.start >= lastEndTime) {
				count++;
				lastEndTime = current.end;
			}
		}
		
		System.out.println(count);
	}
	
}

class Meeting{
	int start;
	int end;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "Meeting [start=" + start + ", end=" + end + "]";
	}
		
}

