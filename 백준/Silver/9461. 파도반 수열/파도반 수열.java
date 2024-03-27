import java.io.*;
import java.util.*;
public class Main {

    static int N, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        int[] t = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            t[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, t[i]);
        }
        long[] dp = new long[max + 1];
        if(max > 2){
            dp[1] = dp[2] = dp[3] = 1;

            for (int i = 4; i <= max; i++) {
                dp[i] = dp[i - 2] + dp[i - 3];
            }
        }
        else Arrays.fill(dp, 1);
        for (int i = 0; i < T; i++) {
            sb.append(dp[t[i]]).append('\n');
        }
        System.out.println(sb);
    }
}