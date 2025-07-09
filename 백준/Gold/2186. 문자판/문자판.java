import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2186

public class Main {
    static int N, M, K;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static char[] target;
    static int end;
    static int[][][] dp;
    static boolean oufOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    static int search(int x, int y, int depth){
        if(depth >= end) return 1;
        if(dp[x][y][depth] != -1) return dp[x][y][depth];
        int ret = 0;


        for (int k = 1; k <= K; k++) {
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d] * k;
                int ny = y + dy[d] * k;
                if(oufOfMap(nx, ny)) continue;
                if(map[nx][ny] != target[depth]) continue;
                ret += search(nx, ny, depth + 1);
            }
        }

        return dp[x][y][depth] = ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        target = br.readLine().toCharArray();
        end = target.length;

        dp = new int[N][M][end];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != target[0]) continue;
                ans += search(i, j, 1);
            }
        }
        
        System.out.println(ans);
    }
}
