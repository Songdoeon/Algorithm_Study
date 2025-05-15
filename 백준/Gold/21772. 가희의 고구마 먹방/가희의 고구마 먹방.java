import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T;
    static int[] dx = {-1, 0, 1, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0};
    static char[][] map;
    static int ans = 0;
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    static void search(int x, int y, int t, int g){
        if(t > T) return ;

        ans = Math.max(ans, g);
        for (int d = 0; d < 5; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(outOfMap(nx, ny))continue;
            if(map[nx][ny] == '#')continue;
            if(map[nx][ny] == 'S'){
                map[nx][ny] = '.';
                search(nx, ny, t + 1, g + 1);
                map[nx][ny] = 'S';
            }
            else search(nx, ny, t + 1, g);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        int sx = 0;
        int sy = 0;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'G'){
                    sx = i;
                    sy = j;
                }
            }
        }
        search(sx, sy, 0, 0);

        System.out.println(ans);
    }
}
