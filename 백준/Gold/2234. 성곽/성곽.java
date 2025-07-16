import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] castle;
    static int[][] comp;
    static boolean[][] visited;
    static int[] roomSize;
    // directions: west, north, east, south
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] wallBit = {1, 2, 4, 8};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        castle = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comp = new int[N][M];
        visited = new boolean[N][M];
        List<Integer> sizes = new ArrayList<>();
        sizes.add(0); // dummy at index 0

        // 1) Flood-fill to label components
        int compCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    compCount++;
                    int size = bfs(i, j, compCount);
                    sizes.add(size);
                }
            }
        }

        // 2) Find largest room
        int maxRoom = 0;
        for (int sz : sizes) {
            if (sz > maxRoom) maxRoom = sz;
        }

        // 3) Try removing each wall
        int maxMerge = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int c1 = comp[i][j];
                for (int d = 0; d < 4; d++) {
                    if ((castle[i][j] & wallBit[d]) != 0) {
                        int ni = i + dx[d], nj = j + dy[d];
                        if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
                            int c2 = comp[ni][nj];
                            if (c1 != c2) {
                                int merged = sizes.get(c1) + sizes.get(c2);
                                if (merged > maxMerge) {
                                    maxMerge = merged;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(compCount + "\n" + maxRoom + "\n" + maxMerge);
    }

    static int bfs(int si, int sj, int label) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{si, sj});
        visited[si][sj] = true;
        comp[si][sj] = label;
        int size = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            int walls = castle[x][y];
            for (int d = 0; d < 4; d++) {
                if ((walls & wallBit[d]) == 0) {
                    int nx = x + dx[d], ny = y + dy[d];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M 
                            && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        comp[nx][ny] = label;
                        size++;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return size;
    }
}
