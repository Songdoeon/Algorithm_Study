import java.io.*;
import java.util.*;

class Main{
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M, K;
    static char[][] map;
    static boolean[][] visited;
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    static int result = 0;
    static void search(int x, int y, int dis){
        if(dis == K && x == 0 && y == M - 1){
            result++;
            return ;
        }
        if(dis > K)return ;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(outOfMap(nx, ny)) continue;
            if(map[nx][ny] == 'T')continue;
            if(visited[nx][ny])continue;
            visited[nx][ny] = true;
            search(nx, ny, dis + 1);
            visited[nx][ny] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visited[N - 1][0] = true;
        search(N - 1, 0, 1);
        System.out.println(result);
    }
}