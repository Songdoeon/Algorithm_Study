import java.util.*;
import java.io.*;

class Main{
    static int N, K;
    static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        long[][] dp = new long[K + 1][N + 1];

        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= K; i++) {
            dp[i][1] = i;
        }
        dp[1][0] = 0;
        for (int i = 2; i <= K; i++) {
            for (int j = 2; j <= N; j++) {
                for (int k = i; k >= 1; k--) {
                    dp[i][j] += dp[k][j - 1] % MOD;
                }
            }
        }

        System.out.println(dp[K][N] % MOD);
    }
}