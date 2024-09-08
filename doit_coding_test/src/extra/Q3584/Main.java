package extra.Q3584;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer>[] tree;
	static int[] depth,parent;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/extra/Q3584/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int N = sc.nextInt();
			tree = new ArrayList[N+1];
			depth = new int[N+1];
			parent = new int[N+1];
			visited = new boolean[N+1];
			
			for(int i=1;i<=N;i++) {
				tree[i] = new ArrayList<>();
			}
			
			HashSet<Integer> nodes = new HashSet<>();
			for(int i=1;i<=N;i++) {
				nodes.add(i);
			}
			
			for(int i=0;i<N-1;i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				
				tree[s].add(e);
				tree[e].add(s);
				
				nodes.remove(e);
			}
			
			int rootNode = nodes.iterator().next();
			
			bfs(rootNode);
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			int LCA = excuteLCA(a,b);
			
			System.out.println(LCA);
			
		}
		
	}
	
	public static int excuteLCA(int a, int b) {
		if(depth[a]<depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		while(depth[a]!=depth[b]) {
			a = parent[a];
		}
		
		while(a!=b) {
			a = parent[a];
			b = parent[b];
		}
		
		return a;
	}
	
	public static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		
		int level=1;
		int node_size=1;
		int count=0;
		
		while(!queue.isEmpty()) {
			int now_node = queue.poll();
			for(int next:tree[now_node]) {
				if(!visited[next]) {
					visited[next]=true;
					queue.add(next);
					parent[next]=now_node;
					depth[next]=level;
				}
			}
			
			count++;
			if(count==node_size) {
				count=0;
				node_size=queue.size();
				level++;
			}
		}
	}

}
