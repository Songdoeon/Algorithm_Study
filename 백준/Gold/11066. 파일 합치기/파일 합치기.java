import java.io.*;
import java.util.*;

class Main {
    static int T, N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        Queue<Integer> queue;
        int[] arr = new int[1];
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N + 1][N + 1];
            for(int diff = 1; diff <= N; diff++){
                for (int start = 1; start + diff <= N; start++) {
                    int end = start + diff;
                    dp[start][end] = 500_000_001;
                    for (int k = start; k < end; k++) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][k] + dp[k + 1][end] + arr[end] - arr[start - 1]);
                    }
                }
            }
           sb.append(dp[1][N]).append('\n');
        }
        System.out.println(sb);
    }
}