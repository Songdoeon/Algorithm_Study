import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 10:26 시작

class Main {
    static int N, M, T;
    static int[][] map;
    static int[][][] dp;
    static final int INF = 987_654_321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[3][N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                dp[j][0][i] = map[0][i];
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int n = map[i][j];
                if(j == 0){
                    dp[1][i][j] = dp[2][i - 1][j] + n;
                    dp[2][i][j] = Math.min(dp[1][i - 1][j + 1],dp[0][i - 1][j + 1]) + n;
                }
                else if(j == M - 1){
                    dp[1][i][j] = dp[0][i - 1][j] + n;
                    dp[0][i][j] = Math.min(dp[1][i - 1][j - 1],dp[2][i - 1][j - 1]) + n;
                }else{
                    dp[0][i][j] = Math.min(dp[1][i - 1][j - 1], dp[2][i - 1][j - 1]) + n;
                    dp[1][i][j] = Math.min(dp[0][i - 1][j],     dp[2][i - 1][j]) + n;
                    dp[2][i][j] = Math.min(dp[0][i - 1][j + 1], dp[1][i - 1][j + 1]) + n;
                }
            }
        }

        int ans = INF;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                ans = Math.min(ans, dp[j][N - 1][i]);
            }
        }

        System.out.println(ans);
    }
}