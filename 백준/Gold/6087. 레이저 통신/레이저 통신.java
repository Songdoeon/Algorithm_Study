import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

class Pos{
    int x, y, dir, cnt;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
        dir = -1;
        cnt = 0;
    }

    public Pos(int x, int y, int dir, int cnt) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cnt = cnt;
    }
}
public class Main {
    static int N, M;
    static char[][] map;
    static int[][] visited;
    static int[] dx = {1, -1, 0 ,0};
    static int[] dy = {0, 0, -1 ,1};
    static final int INF = 100_002;
    static boolean outOfMap(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], INF);
        }
        Pos start = new Pos(-1, -1);
        Pos end = new Pos(-1, -1);
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'C'){
                    if(start.x == -1 && start.y == -1) start = new Pos(i, j);
                    else end = new Pos(i, j);
                }
            }
        }

        Deque<Pos> queue = new ArrayDeque<>();

        queue.add(start);
        visited[start.x][start.y] = 0;

        int ans = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Pos p = queue.poll();
            int curDir = p.dir;
            if(p.x == end.x && p.y == end.y) {
                ans = Math.min(ans, p.cnt);
            }
            for(int d = 0; d < 4; d++){
                int x = p.x + dx[d];
                int y = p.y + dy[d];
                if(outOfMap(x, y)) continue;
                if(map[x][y] == '*')continue;
                if(curDir == -1) queue.offerFirst(new Pos(x, y, d, p.cnt));
                else if(curDir != d) {
                    if(p.cnt + 1 >= visited[x][y]) continue;
                    visited[x][y] = p.cnt + 1;
                    queue.offerLast(new Pos(x, y, d, p.cnt + 1));
                }
                else {
                    if(p.cnt > visited[x][y]) continue;
                    visited[x][y] = p.cnt;
                    queue.offerFirst(new Pos(x, y, d, p.cnt));
                }
            }
        }
        System.out.println(ans);
    }
}
