import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 17208

public class Main {
    static int N, M, K;
    static int[][] arr;
    static int[][][] dp;

    static int search(int idx, int x, int y){
        if(idx == N) return 0;
        if(dp[idx][x][y] != -1) return dp[idx][x][y];

        int ret = search(idx + 1, x, y);

        if(x >= arr[idx][0] && y >= arr[idx][1]){
            ret = Math.max(ret, search(idx + 1, x - arr[idx][0], y - arr[idx][1]) + 1);
        }

        return dp[idx][x][y] = ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][2];
        dp = new int[N][M + 1][K + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }

        System.out.println(search(0, M, K));
    }
}
