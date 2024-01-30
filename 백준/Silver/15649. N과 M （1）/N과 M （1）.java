import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static boolean[] visited;
	static void search(int depth, String str) {
		if(depth == M) {
			System.out.println(str.substring(1));
		}
		
		for(int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			search(depth + 1, str + " " + i);
			visited[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arg = br.readLine().split(" ");
		
		N = Integer.parseInt(arg[0]);
		M = Integer.parseInt(arg[1]);
		visited = new boolean[N + 1];
		search(0,"");
	}
}
