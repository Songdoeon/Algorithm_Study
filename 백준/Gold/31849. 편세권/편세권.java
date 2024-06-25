import java.io.*;
import java.util.*;

class Pos{
    int x;
    int y;
    int dis;
    int cost;
    Pos(int x, int y, int cost, int dis){
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dis = dis;
    }
}
class Main {
    static int N, M, R, C;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] costs;
    static boolean outOfMap(int x, int y){
        return x < 1 || x > N || y < 1 || y > M;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        costs = new int[N + 1][M + 1];
        for (int[] cost : costs) {
            Arrays.fill(cost, 100_000_000);
        }
        PriorityQueue<Pos> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.dis));
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(outOfMap(nx, ny)) continue;
                queue.offer(new Pos(nx, ny, c, c));
            }
        }

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = -1;
        }
        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            if(map[p.x][p.y] == -1){
                System.out.println(p.dis);
                return ;
            }
            if(visited[p.x][p.y])continue;
            visited[p.x][p.y] = true;
            int dis = p.dis + p.cost;
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if(outOfMap(nx, ny)) continue;
                if(costs[nx][ny] >= dis) {
                    costs[nx][ny] = dis;
                    queue.offer(new Pos(nx, ny, p.cost, dis));
                }
            }
        }
    }
}
