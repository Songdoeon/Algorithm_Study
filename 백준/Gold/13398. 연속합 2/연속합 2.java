import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[] dp, dp2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];
        dp2 = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        int ans = -100_000_001;
        dp[0] = -100_000_001;
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i - 1] + n, n);
            dp2[i] = Math.max(dp[i - 1], dp2[i - 1] + n);
            ans = Math.max(Math.max(dp[i], ans), dp2[i]);
        }
        System.out.println(ans);
    }
}