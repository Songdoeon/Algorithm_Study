import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Pos{
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static Pos start, end;

    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Queue<Pos> queue = new ArrayDeque<>();
        Queue<Pos> waterQueue = new ArrayDeque<>();
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'D') end = new Pos(i, j);
                else if (map[i][j] == 'S') {
                    start = new Pos(i, j);
                    queue.offer(start);
                    visited[i][j] = true;
                }
                else if (map[i][j] == '*') waterQueue.offer(new Pos(i, j));
            }
        }
        boolean exit = false;


        int time = 1;
        while (!queue.isEmpty()){
            int waterSize = waterQueue.size();
            for (int i = 0; i < waterSize; i++) {
                Pos p = waterQueue.poll();
                if(visited[p.x][p.y])continue;
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    if (outOfMap(nx, ny)) continue;
                    if (visited[nx][ny]) continue;
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        waterQueue.offer(new Pos(nx, ny));
                    }
                }
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pos p = queue.poll();
                if(map[p.x][p.y] == '*') continue;
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];

                    if (outOfMap(nx, ny)) continue;
                    if (visited[nx][ny]) continue;
                    if (map[nx][ny] == '*' || map[nx][ny] == 'X') continue;
                    visited[nx][ny] = true;
                    queue.offer(new Pos(nx, ny));
                    if(nx == end.x && ny == end.y){
                        exit = true;
                        break;
                    }
                }
                if(exit) break;
            }
            if(exit) break;
            time++;
        }
        System.out.println(exit ? time : "KAKTUS");
    }
}