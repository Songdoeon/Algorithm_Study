import java.io.*;
import java.util.*;

class Pos{
    int x, y;
    boolean check;

    public Pos(int x, int y, boolean check) {
        this.x = x;
        this.y = y;
        this.check = check;
    }
}
public class Main {
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static boolean pos;
    static char[][] map;
    static int[][] visited;
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new int[N][M];
        Queue<Pos > q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        pos = map[0][0] == '#' ? true : false;

        q.offer(new Pos(0, 0, pos));
        visited[0][0] = 0;
        while (!q.isEmpty()){
            Pos p = q.poll();
            if(p.x == N - 1 && p.y == M - 1) break;
            for (int d = 0; d < 4; d++) {
                int cx = p.x + dx[d];
                int cy = p.y + dy[d];
                if(outOfMap(cx, cy)) continue;
                if(visited[cx][cy] != 0) continue;
                if(p.check && map[cx][cy] == '#') continue;
                if(!p.check && map[cx][cy] == '.') continue;
                visited[cx][cy] = visited[p.x][p.y] + 1;
                q.offer(new Pos(cx, cy, !p.check));
            }
        }

        System.out.println(visited[N - 1][M - 1] == 0 ? "-1" : visited[N - 1][M - 1]);
    }
}