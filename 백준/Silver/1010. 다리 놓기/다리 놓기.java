import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] dp;
        int N, M;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            dp = new int[M + 1][M + 1];
            dp[0][0] = 1;

            for (int i = 1; i <= M; i++) {
                for (int j = 0; j <= i; j++) {
                    if(j == 0 || j == i){
                        dp[i][j] = 1;
                        continue;
                    }
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
            System.out.println(dp[M][N]);
        }
    }
}
