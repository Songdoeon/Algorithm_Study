import java.util.*;
import java.io.*;
class Main {
    static int N, K;
    static char[] arr1, arr2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr1 = br.readLine().toCharArray();
        arr2 = br.readLine().toCharArray();

        int[][] dp = new int[N +2][K + 1];

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if(arr2[i - 1] == arr1[j - 1]) dp[j][i] = Math.max(dp[j + 1][i - 1], dp[j - 1][i - 1]) + 1;
                else dp[j][i] = Math.max(dp[j + 1][i - 1], dp[j - 1][i - 1]);
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dp[i][K]);
        }
        System.out.println(ans);
    }
}
