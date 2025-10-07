import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 28450

public class Main {
    static int N, M, H;
    static int[][] map;
    static long[][] dp;
    static final long INF = Long.MAX_VALUE / 4;
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    static long search(int x, int y){
        if(x == N - 1 && y == M - 1) {
            return map[x][y];
        }

        if(dp[x][y] != -1) return dp[x][y];

        long ret = INF;

        if(!outOfMap(x, y + 1)) {
            long cost = search(x, y + 1);
            if(cost != INF) ret = cost + map[x][y];
        }

        if(!outOfMap(x + 1, y)) {
            long cost = search(x + 1, y);
            if(cost != INF) ret = Math.min(ret, cost + map[x][y]);
        }

        return dp[x][y] = ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new long[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        H = Integer.parseInt(br.readLine());

        long ans = search(0, 0);
        System.out.println(ans > H ? "NO" : "YES" + '\n' + ans);
    }
}
