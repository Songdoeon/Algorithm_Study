import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<ArrayList<Integer>> list = new ArrayList<>();
		int[] linked = new int[N + 1];
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			list.get(n1).add(n2);
			linked[n2]++;
		}
		
		for(int i = 1; i <= N; i++) {
			if(linked[i] == 0) {
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			int n = queue.poll();
			sb.append(n).append(" ");
			for(int next : list.get(n)) {
				if(--linked[next] == 0) {
				    queue.add(next);
			    }
		    }
		}
		System.out.println(sb);
		br.close();
	}
}