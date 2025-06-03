import java.io.*;
import java.util.*;

// 33993

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int R = W / 2;

        int[][] imos = new int[N + 2][M + 2];
        boolean[][] visited = new boolean[N + 2][M + 2];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            visited[sx][sy] = true;
            int x1 = sx - R; if (x1 < 1)   x1 = 1;
            int x2 = sx + R; if (x2 > N)   x2 = N;
            int y1 = sy - R; if (y1 < 1)   y1 = 1;
            int y2 = sy + R; if (y2 > M)   y2 = M;

            imos[x1][y1]     += 1;
            imos[x2 + 1][y1] -= 1;
            imos[x1][y2 + 1] -= 1;
            imos[x2 + 1][y2 + 1] += 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                imos[i][j] += imos[i - 1][j];
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= M; j++) {
                imos[i][j] += imos[i][j - 1];
            }
        }

        int max = 0;
        int total = 0;
        int ansX = N;
        int ansY = M;
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= M; y++) {
                if(visited[x][y]) continue;
                if (imos[x][y] > max) {
                    ansX = x;
                    ansY = y;
                    total = 1;
                    max = imos[x][y];
                }
                else if(imos[x][y] == max) {
                    total++;
                    if (x < ansX || (x == ansX && y < ansY)) {
                        ansX = x;
                        ansY = y;
                    }
                }
            }
        }
        System.out.println(max + "\n" + ansX + " " + ansY);
    }
}
