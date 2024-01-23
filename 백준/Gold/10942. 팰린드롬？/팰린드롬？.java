import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	static int[][] dp;
	static void fillDP(int N) {
	    for (int i = 1; i <= N; i++) {
	        dp[i][i] = 1;
	    }

	    for (int len = 2; len <= N; len++) {
	        for (int i = 1; i <= N - len + 1; i++) {
	            int j = i + len - 1;

	            if (len == 2) {
	                dp[i][j] = (arr[i] == arr[j]) ? 1 : 0;
	            } else {
	                dp[i][j] = (arr[i] == arr[j] && dp[i + 1][j - 1] == 1) ? 1 : 0;
	            }
	        }
	    }
	}

	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new int[N + 1][N + 1];
		int i, start, end;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		fillDP(N);
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());	
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());

			sb.append(dp[start][end]).append('\n');
		}
		bw.write(sb.toString());
		bw.newLine();
		bw.flush();
		bw.close();
	}
}