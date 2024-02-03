import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[12];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i < 12; i++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        for(int i = 0; i < N;i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}