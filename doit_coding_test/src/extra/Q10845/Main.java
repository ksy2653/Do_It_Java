package extra.Q10845;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/extra/Q10845/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if(command.equals("push"))
				queue.add(Integer.parseInt(st.nextToken()));
			
			else if(command.equals("pop")) {
				if(queue.isEmpty())
					System.out.println(-1);
				else
					System.out.println(queue.poll());
			}
			
			else if(command.equals("size"))
				System.out.println(queue.size());
			
			else if(command.equals("empty")) {
				if(queue.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			}
			
			else if(command.equals("front")) {
				if(!queue.isEmpty())
					System.out.println(queue.peek());
				else
					System.out.println(-1);
			}
			
			else if(command.equals("back")) {
				if(!queue.isEmpty())
					if(queue.size()==1)
						System.out.println(queue.peek());
					else {
						for(int j=0;j<queue.size()-1;j++) {
							int temp = queue.poll();
							queue.add(temp);
						}
						int result = queue.poll();
						System.out.println(result);
						queue.add(result);
					}
				else
					System.out.println(-1);
			}
			
			else
				System.out.println("wrong input");
		}
	}

}
