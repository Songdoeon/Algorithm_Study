import java.util.*;
import java.io.*;

public class Main {
    static int T, N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        int[][] arr, dp;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[2][N + 1];
            dp = new int[2][N + 2];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 2; i <= N + 1; i++) {
                dp[0][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + arr[0][i - 1];
                dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + arr[1][i - 1];
            }
            System.out.println(Math.max(dp[0][N + 1], dp[1][N + 1]));
        }




    }
}
