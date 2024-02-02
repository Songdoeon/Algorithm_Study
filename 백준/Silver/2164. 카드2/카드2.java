import java.io.*;
import java.util.*;
public class Main {	
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Deque<Integer> queue = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		while(queue.size() != 1) {
			queue.poll();
			queue.add(queue.poll());
		}
		System.out.println(queue.poll());
	}
}
