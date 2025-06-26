import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans1 = 0;
        int ans2 = 0;

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new char[N][M];

        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j])continue;
                int cnt = 1;
                char c = map[i][j];
                queue.add(new int[]{i, j});
                visited[i][j] = true;
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if(outOfMap(nx, ny)) continue;
                        if(c != map[nx][ny]) continue;
                        if(visited[nx][ny]) continue;
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        cnt++;
                    }
                }
                if(c == 'W') ans1 += Math.pow(cnt, 2);
                else ans2 += Math.pow(cnt, 2);
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}
