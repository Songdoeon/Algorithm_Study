import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1103

class Pos{
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static char[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static boolean find = false;
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    static int search(int x, int y){
        if(find) return 0;

        if(visited[x][y]){
            find = true;
            return 0;
        }

        if(dp[x][y] != -1) return dp[x][y];

        visited[x][y] = true;
        int ret = 0;
        int dis = map[x][y] - '0';
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d] * dis;
            int ny = y + dy[d] * dis;
            if (outOfMap(nx, ny)) continue;
            if (map[nx][ny] == 'H') continue;
            ret = Math.max(ret, search(nx, ny) + 1);
        }

        visited[x][y] = false;

        return dp[x][y] = ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N][M];
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], -1);
        
        int ans = search(0, 0);
        System.out.println(find ? -1 : ans + 1);


    }
}
