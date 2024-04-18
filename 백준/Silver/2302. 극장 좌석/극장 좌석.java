import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[]  arr;
    static int[] dp = new int[41];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 2; i < 41; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int start = 1;
        int ans = 1;
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            ans *= dp[num - start];
            start = num + 1;
        }
        ans *= dp[N + 1 - start];
        System.out.println(ans);
    }
}