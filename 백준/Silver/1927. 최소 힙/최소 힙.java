import java.util.*;
import java.io.*;

public class Main {
	 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0 && !queue.isEmpty()) {
                sb.append(queue.poll()).append('\n');
			}
			else if(n == 0 && queue.isEmpty()) {
                sb.append("0").append('\n');
			}
			else {
				queue.add(n);
			}
		}
        System.out.println(sb);
	}
}
