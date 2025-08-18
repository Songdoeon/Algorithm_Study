import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 11967

class Pos{
    int x, y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] map;
    static boolean[][] visited;
    static List<Pos>[][] light;
    static boolean outOfMap(int x, int y){
        return x < 1 || x > N || y < 1 || y > N;
    }

    static void turnOn(int x, int y){
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(outOfMap(nx, ny))continue;
            visited[nx][ny] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1][N + 1];
        map = new boolean[N + 1][N + 1];
        light = new List[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                light[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            light[x][y].add(new Pos(x2, y2));
        }
        int ans = 1;
        map[1][1] = true;

        Queue<Pos> q = new ArrayDeque<>();

        for (Pos p : light[1][1]) {
            if(map[p.x][p.y])continue;
            map[p.x][p.y] = true;
            ans++;
        }
        while (true){
            int temp = 0;
            q.add(new Pos(1, 1));
            for (int i = 1; i <= N; i++) Arrays.fill(visited[i], false);
            visited[1][1] = true;
            while (!q.isEmpty()) {
                Pos cur = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(outOfMap(nx, ny))continue;
                    if(visited[nx][ny])continue;
                    if(!map[nx][ny])continue;
                    visited[nx][ny] = true;

                    for (Pos p : light[nx][ny]) {
                        if(map[p.x][p.y])continue;
                        map[p.x][p.y] = true;
                        turnOn(p.x, p.y);
                        temp++;
                    }
                    q.offer(new Pos(nx, ny));
                }
            }
            if(temp == 0)break;
            ans += temp;
        }

        System.out.println(ans);

    }
}
