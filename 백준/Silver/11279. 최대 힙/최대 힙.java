import java.io.*;
import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		Queue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.isEmpty()) sb.append(0).append("\n");
				else sb.append(pq.poll()).append("\n");
			}
            else pq.offer(x);
		}
        
		System.out.println(sb);
	}

}