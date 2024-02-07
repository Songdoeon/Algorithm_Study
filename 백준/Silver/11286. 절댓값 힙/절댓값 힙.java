import java.util.*;
import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> Math.abs(o1) == Math.abs(o2) 
															? o1 - o2 
															: Math.abs(o1) - Math.abs(o2));
		
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				if(queue.isEmpty())sb.append("0").append('\n');
				else sb.append(queue.poll()).append('\n');
			}
			else queue.offer(n);
		}
		
		System.out.println(sb);
	}
}
