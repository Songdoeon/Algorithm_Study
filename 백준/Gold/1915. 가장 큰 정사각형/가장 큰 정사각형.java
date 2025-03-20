import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] dp;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                dp[i][j] = map[i][j] - '0';
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if(map[i][j] != '1')continue;
                if(dp[i - 1][j - 1] >= 1 && dp[i][j - 1] >= 1 && dp[i - 1][j] >= 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
                if(map[i - 1][j - 1] == '1' && map[i - 1][j] == '1' && map[i][j - 1] == '1') dp[i][j]++;
            }
        }
        int ans = 0;
        for (int[] ints : dp) {
            for (int anInt : ints) {
                ans = Math.max(ans, anInt);
            }
        }
        System.out.println(ans * ans);
    }
}
