import java.util.*;
import java.io.*;

public class Main {
	 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int answer = 0;
		int graph[][] = new int [N + 1][N + 1];
		boolean[] visited = new boolean[N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			graph[n1][n2] = 1;
			graph[n2][n1] = 1;
		}

		queue.add(1);
		visited[1] = true;
		while(!queue.isEmpty()) {
			int computer = queue.poll();
			visited[computer] = true;
			for(int i = 1; i <= N;i++) {
				if(graph[computer][i] == 1 && !visited[i]) {
					queue.add(i);
					answer++;
					visited[i] = true;
				}
			}
		}
		System.out.println(answer);
	}
}
