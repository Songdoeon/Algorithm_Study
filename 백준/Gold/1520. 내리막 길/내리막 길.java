import java.io.*;
import java.util.*;

class Pos{
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Main {
    static int N, M;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static int[][] dp;
    static int[][] map;
    static boolean outOfMap(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    static int search(int x, int y){
        if(x == N - 1 && y == M - 1) return 1;

        if(dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (outOfMap(nx, ny)) continue;
            if(map[nx][ny] >= map[x][y]) continue;
            dp[x][y] += search(nx, ny);
        }
        return dp[x][y];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(search(0, 0));
    }
}
