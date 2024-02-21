import java.io.*;
import java.util.*;

class Pos{
    int x;
    int y;
    int type;
    int result;

    public Pos(int x, int y, int type, int result) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.result = result;
    }
}
public class Main {
    static int N, M;

    static int[][] map;
    static Pos[][] dp;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<int[]> dpQueue = new ArrayDeque<>();
        map = new int[N][M];
        dp = new Pos[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0 && !visited[i][j]){
                    idx++;
                    queue.offer(new int[] {i, j});
                    dpQueue.offer(new int[] {i, j});
                    visited[i][j] = true;
                    int result = 1;
                    while (!queue.isEmpty()){
                        int[] p = queue.poll();
                        for(int d = 0; d < 4; d++){
                            int nx = p[0] + dx[d];
                            int ny = p[1] + dy[d];
                            if(outOfMap(nx, ny) || map[nx][ny] == 1) continue;
                            if(visited[nx][ny]) continue;
                            visited[nx][ny] = true;
                            dpQueue.add(new int[] {nx, ny});
                            queue.add(new int[] {nx, ny});
                            result++;
                        }
                    }

                    while (!dpQueue.isEmpty()){
                        int[] p = dpQueue.poll();
                        dp[p[0]][p[1]] = new Pos(p[0], p[1], idx, result);
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1){
                    Set<Integer> set = new HashSet<>();
                    for(int d = 0; d < 4; d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(outOfMap(nx, ny) || map[nx][ny] != 0) continue;
                        if(set.contains(dp[nx][ny].type))continue;
                        map[i][j] += dp[nx][ny].result;
                        set.add(dp[nx][ny].type);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j] % 10);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}