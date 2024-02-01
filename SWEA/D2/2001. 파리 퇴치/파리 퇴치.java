import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] board = new int[N][N];
            int[][] prefixSum = new int[N + 1][N + 1];
            int max = Integer.MIN_VALUE; 
            for (int i = 0; i < N; i++) {
                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    prefixSum[i][j] = board[i - 1][j - 1] + prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i -1][j - 1];
                }
            }
            for (int i = 1; i <= N - M + 1; i++) {
                for (int j = 1; j <= N - M + 1; j++) {
                    int sum = prefixSum[M + i - 1][M + j - 1] - prefixSum[M + i - 1][j - 1] - prefixSum[i - 1][M + j - 1] + prefixSum[i - 1][j - 1];
                    max = Math.max(sum, max);
                }
            }
            sb.append("#").append(t).append(" ").append(max).append('\n');

        }
		System.out.println(sb.toString());
	}

	
}
