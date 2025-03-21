import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] dp;
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= N;
    }
    static int search(int x, int y){
        if(dp[x][y] != -1) return dp[x][y];
        dp[x][y] = 1;
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(outOfMap(nx, ny))continue;
            if(map[x][y] >= map[nx][ny]) continue;
            dp[x][y] = Math.max(dp[x][y], search(nx, ny) + 1);
        }
        return dp[x][y];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, search(i, j));
            }
        }
        System.out.println(ans);
    }
}