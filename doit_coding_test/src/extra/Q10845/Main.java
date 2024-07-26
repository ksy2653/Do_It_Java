package extra.Q10845;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여섯 가지이다.

push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 */

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
