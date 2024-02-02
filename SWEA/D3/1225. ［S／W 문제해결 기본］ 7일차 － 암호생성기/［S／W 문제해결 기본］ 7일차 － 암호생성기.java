import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> queue = new ArrayDeque<>();
		StringTokenizer st;
		int cnt;
		int T = 10;
		for(int t = 1; t <= T; t++){
			cnt = 1;
			br.readLine();
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			while(queue.peek() > cnt) {
				
				int n = queue.poll();
				n -= cnt++;
				queue.offer(n);
				if(cnt > 5) cnt = 1;
			}
			queue.poll();
			queue.offer(0);
			sb.append("#").append(t).append(" ");
			while(!queue.isEmpty()) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	
}
