import java.io.*;
import java.util.*;
public class Main {

    static int N, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        int[] t = new int[T];
        for (int i = 0; i < T; i++) {
            t[i] = Integer.parseInt(br.readLine());
        }
        long[] dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1;

        for (int i = 4; i <= 100; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        for (int i = 0; i < T; i++) {
            sb.append(dp[t[i]]).append('\n');
        }
        System.out.println(sb);
    }
}