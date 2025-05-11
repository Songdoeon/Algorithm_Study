import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int N, K, R;
    static boolean[][][] roads;
    static int[] dx = {-1, 0, 1,  0};
    static int[] dy = { 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        roads = new boolean[N][N][4];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            if (r2 == r1 - 1 && c2 == c1)       { roads[r1][c1][0] = true; roads[r2][c2][2] = true; }
            else if (r2 == r1 && c2 == c1 + 1)  { roads[r1][c1][1] = true; roads[r2][c2][3] = true; }
            else if (r2 == r1 + 1 && c2 == c1)  { roads[r1][c1][2] = true; roads[r2][c2][0] = true; }
            else if (r2 == r1 && c2 == c1 - 1)  { roads[r1][c1][3] = true; roads[r2][c2][1] = true; }
        }

        int[][] cows = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken()) - 1;
            cows[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        int ans = 0;
        boolean[][] visited = new boolean[N][N];
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            for (int r = 0; r < N; r++) Arrays.fill(visited[r], false);
            queue.clear();

            int sr = cows[i][0], sc = cows[i][1];
            visited[sr][sc] = true;
            queue.offer(new int[]{sr, sc});

            while (!queue.isEmpty()) {
                int[] p = queue.poll();
                int r = p[0], c = p[1];
                for (int d = 0; d < 4; d++) {
                    if (roads[r][c][d]) continue;
                    int nr = r + dx[d], nc = c + dy[d];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if (visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }

            for (int j = i + 1; j < K; j++) {
                int rr = cows[j][0], cc = cows[j][1];
                if (!visited[rr][cc]) ans++;
            }
        }

        System.out.println(ans);
    }
}
