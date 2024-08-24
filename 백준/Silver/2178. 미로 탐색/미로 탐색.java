import java.io.*;

import java.util.*;

class Pos{
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Main {
    static int N, M;
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

        char[][] map = new char[N][M];
        int[][] visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(0, 0));
        visited[0][0] = 1;
        while (!q.isEmpty()) {
            Pos p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(outOfMap(nx, ny)) continue;
                if(visited[nx][ny] != 0) continue;
                if(map[nx][ny] == '0') continue;
                visited[nx][ny] = visited[p.x][p.y] + 1;
                q.add(new Pos(nx, ny));
            }
        }
        System.out.println(visited[N-1][M-1]);
    }
}