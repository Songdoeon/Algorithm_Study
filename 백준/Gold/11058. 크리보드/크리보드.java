import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        long[] dp = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 3; j <= i; j++) {
                long n = dp[i - j] * (j - 1);
                if (n > dp[i]) {
                    dp[i] = n;
                }
            }
        }

        System.out.println(dp[N]);
    }
}
