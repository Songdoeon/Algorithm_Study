import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
        int n, n1, n2;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<ArrayList<Integer>> list = new ArrayList<>();
		int[] linked = new int[N];
		for(int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			list.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken()) - 1;
			n2 = Integer.parseInt(st.nextToken()) - 1;
			list.get(n1).add(n2);
			linked[n2]++;
		}
		
		for(int i = 0; i < N; i++) {
			if(linked[i] == 0) {
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			n = queue.poll();
			sb.append(n+1).append(" ");
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