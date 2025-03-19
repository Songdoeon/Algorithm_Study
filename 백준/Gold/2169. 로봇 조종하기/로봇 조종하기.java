import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] dx = {1, 0, 0};
    static int[] dy = {0, 1, -1};
    static int[][][] dp;
    static int[][] map;
    static boolean[][] visited;
    static boolean outOfMap(int x, int y) {
        return x < 1 || x > N || y < 1 || y > M;
    }
    static int search(int x, int y, int dir){
        if(x == N && y == M) return map[x][y];

        if(dp[dir][x][y] != -101) return dp[dir][x][y];

        visited[x][y] = true;
        int ans = -100_000_000;
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (outOfMap(nx, ny)) continue;
            if(visited[nx][ny]) continue;
            ans = Math.max(ans, search(nx, ny, i) + map[x][y]);
        }
        visited[x][y] = false;
        return dp[dir][x][y] = ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        dp = new int[3][N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 3; k++) {
                    dp[k][i][j] = -101;
                }
            }
        }
        System.out.println(Math.max(search(1, 1, 1),search(1, 1, 0)));
    }
}
