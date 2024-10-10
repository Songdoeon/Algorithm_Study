import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Pos{
    int x, y, z;
    int cnt;

    public Pos(int x, int y, int z, int cnt) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.cnt = cnt;
    }
}
public class Main {
    static int K, N, M;
    static char[][][] map;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Pos start, end;
    static boolean[][][] visited;
    static boolean outOfMap(int x, int y, int z) {
        return x < 0 || x >= K || y < 0 || y >= N || z < 0 || z >= M;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(K == 0 && N == 0 && M == 0) break;
            map = new char[K][N][M];

            visited = new boolean[K][N][M];

            for (int i = 0; i < K; i++) {
                for (int j = 0; j < N; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < M; k++) {
                        map[i][j][k] = line.charAt(k);
                        if(map[i][j][k] == 'S') start = new Pos(i, j, k, 0);
                    }
                }
                br.readLine();
            }

            Queue<Pos> q = new ArrayDeque<>();

            q.add(new Pos(start.x, start.y, start.z, 0));
            int cnt = -1;
            while(!q.isEmpty()){
                Pos p = q.poll();
                if(map[p.x][p.y][p.z] == 'E') {
                    cnt = p.cnt;
                    break;
                }
                for (int i = 0; i < 6; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    int nz = p.z + dz[i];
                    if(outOfMap(nx, ny, nz)) continue;
                    if(map[nx][ny][nz] == '#' ||
                    visited[nx][ny][nz]) continue;
                    visited[nx][ny][nz] = true;
                    q.add(new Pos(nx, ny, nz, p.cnt + 1));
                }
            }
            if(cnt == -1) sb.append("Trapped!");
            else sb.append("Escaped in ").append(cnt).append(" minute(s).");
            sb.append('\n');
        }
        System.out.println(sb);
    }
}