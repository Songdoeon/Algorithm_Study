import java.util.*;
import java.io.*;


class Main{
    static int N, K;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int sum = 0;
        for (int j = 1; j <= K; j++) {
            if(j % arr[1] == 0) dp[1][j]++;
        }
        dp[1][0] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= arr[i]) dp[i][j] += dp[i][j - arr[i]];
            }
        }

        System.out.println(dp[N][K]);
    }
}
