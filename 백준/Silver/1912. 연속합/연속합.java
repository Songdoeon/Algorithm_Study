import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 10:26 시작

class Main {
    static int N;
    static int[] arr, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        int ans = -100_000_001;
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            ans = Math.max(dp[i], ans);
        }
        System.out.println(ans);
    }
}