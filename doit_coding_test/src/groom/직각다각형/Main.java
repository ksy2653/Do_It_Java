package groom.직각다각형;

import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Point> point = new ArrayList<>();
		ArrayList<HorizontalLine> h_line = new ArrayList<>();
		ArrayList<VerticalLine> v_line = new ArrayList<>();
		
		int xMin = 500000;
		int xMax = -500000;
		int yMin = 500000;
		int yMax = -500000;
		
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			point.add(new Point(x,y));
			
			if(xMin > x)
				xMin = x;
			if(xMax < x)
				xMax = x;
			if(yMin > y)
				yMin = y;
			if(yMax < y)
				yMax = y;
		}
		
		for(int i=0;i<N;i++){
			if(i != N-1){
				if(point.get(i).x == point.get(i+1).x)
					v_line.add(new VerticalLine(point.get(i).x,point.get(i).y,point.get(i+1).y));
			
				else
					h_line.add(new HorizontalLine(point.get(i).x, point.get(i+1).x, point.get(i).y));
			}
			else{
				if(point.get(i).x == point.get(0).x)
					v_line.add(new VerticalLine(point.get(i).x,point.get(i).y,point.get(0).y));
			
				else
					h_line.add(new HorizontalLine(point.get(i).x, point.get(0).x, point.get(i).y));
			}
		}
		
		int[] h = new int[yMax-yMin];
		for(int i=0;i<v_line.size();i++){
			int y1 = v_line.get(i).y1;
			int y2 = v_line.get(i).y2;
			
			if(y1>y2){
				int temp = y1;
				y1 = y2;
				y2 = temp;
			}
			
			for(int j=y1;j<y2;j++){
				h[j-yMin]++;
			}
		}
			
		int[] v = new int[xMax-xMin];
		for(int i=0;i<h_line.size();i++){
			int x1 = h_line.get(i).x1;
			int x2 = h_line.get(i).x2;
			
			if(x1>x2){
				int temp = x1;
				x1 = x2;
				x2 = temp;
			}
			
			for(int j=x1;j<x2;j++){
				v[j-xMin]++;
			}
		}
		
		int max=0;
		for(int i=0;i<xMax-xMin;i++){
			max = Math.max(max,v[i]);
		}
		for(int i=0;i<yMax-yMin;i++){
			max = Math.max(max,h[i]);
		}
		
		System.out.print(max);
		
		
	}
}

class Point{
	int x;
	int y;
	
	public Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}

class HorizontalLine{
	int x1;
	int x2;
	int y;
	
	public HorizontalLine(int x1, int x2, int y){
		this.x1=x1;
		this.x2=x2;
		this.y=y;
	}
}

class VerticalLine{
	int x;
	int y1;
	int y2;
	
	public VerticalLine(int x, int y1, int y2){
		this.x=x;
		this.y1=y1;
		this.y2=y2;
	}
}
