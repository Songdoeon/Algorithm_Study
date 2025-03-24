import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 10:33 시작

class Pos{
    int x, y, t;
    boolean knife;

    public Pos(int x, int y, int t, boolean knife) {
        this.x = x;
        this.y = y;
        this.t = t;
        this.knife = knife;
    }
}
class Main {
    static int N, M, T;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][] visited;
    static boolean outOfMap(int x, int y, int d){
        return x < 0 || x >= N || y < 0 || y >= M || visited[d][x][y];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[2][N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(0, 0, 0, false));
        int ans = T + 1;
        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            if(p.t > T)continue;
            if(p.x == N - 1 && p.y == M - 1){
                ans = Math.min(ans, p.t);
            }
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                int k = p.knife ? 1 : 0;
                if(outOfMap(nx, ny, k)) continue;
                if(k == 0 && map[nx][ny] == 1) continue;
                visited[k][nx][ny] = true;
                if(map[nx][ny] == 2) queue.offer(new Pos(nx, ny, p.t + 1, true));
                else queue.offer(new Pos(nx, ny, p.t + 1, p.knife));
            }
        }
        System.out.println(ans > T ? "Fail" : ans);
    }
}