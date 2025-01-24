import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
    int x, y;
    int depth;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
        depth = 0;
    }
    public Pos(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}
public class Main {
    static int N, M;
    static char[][] map;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Queue<Pos> q = new ArrayDeque<>();
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'L') q.offer(new Pos(i, j));
            }
        }
        int ans = 0;
        while (!q.isEmpty()){
            boolean[][] visited = new boolean[N][M];
            Queue<Pos> queue = new ArrayDeque<>();
            Pos start = q.poll();
            queue.offer(start);
            visited[start.x][start.y] = true;
            while (!queue.isEmpty()){
                Pos pos = queue.poll();
                int x = pos.x;
                int y = pos.y;
                ans = Math.max(ans, pos.depth);
                for(int d = 0; d < 4; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(outOfMap(nx, ny)) continue;
                    if(map[nx][ny] == 'W') continue;
                    if(visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    queue.offer(new Pos(nx, ny, pos.depth + 1));
                }
            }
        }
        System.out.println(ans);
    }
}
