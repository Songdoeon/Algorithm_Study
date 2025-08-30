import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] grid;
    static boolean[][] visited;
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static boolean oob(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    static int bfs(int sx, int sy) {
        int cnt = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[sx][sy] = true;
        q.offer(new int[]{sx, sy});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            cnt++;
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (oob(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (grid[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        grid = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> comps = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    comps.add(bfs(i, j));
                }
            }
        }

        Collections.sort(comps);
        StringBuilder sb = new StringBuilder();
        sb.append(comps.size()).append('\n');
        for (int c : comps) sb.append(c).append('\n');
        System.out.print(sb);
    }
}
