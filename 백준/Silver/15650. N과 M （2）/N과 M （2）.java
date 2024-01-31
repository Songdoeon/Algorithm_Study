import java.io.*;
import java.util.*;

public class Main {
	static int[] tgt;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	static void search(int depth, int num) {

		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(tgt[i]).append(" ");
			}
			sb.append('\n');
			return ;
		}

		
		for(int i = num; i <= N; i++) {
			tgt[depth] = i;
			search(depth + 1, i + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arg = br.readLine().split(" ");
		N = Integer.parseInt(arg[0]);
		M = Integer.parseInt(arg[1]);
		tgt = new int[M];
		
		search(0, 1);
		System.out.println(sb);
	}
}