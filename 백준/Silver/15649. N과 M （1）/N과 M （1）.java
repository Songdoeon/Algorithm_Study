import java.util.*;
import java.io.*;

public class Main{
	static int N, M;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static void search(int depth, StringBuilder tempsb) {
		if(depth == M) {
			sb.append(tempsb.substring(1)).append('\n');
		}
		for(int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			int num = tempsb.length();
			tempsb.append(" ").append(i);
			search(depth + 1, tempsb);
			if(depth == 0)tempsb.setLength(0);
			else tempsb.setLength(num);
			visited[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder tempSb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		search(0,tempSb);
		System.out.println(sb);
	}
}
