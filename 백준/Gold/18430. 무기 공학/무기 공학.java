    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    // 18430

    public class Main {
        static int N, M;
        static int[][] map;
        static int[] dx = {1, 1, -1, -1};
        static int[] dy = {-1, 1, 1, -1};
        static boolean[][] visited;
        static int ans = 0;

        static boolean outOfMap(int x, int y){
            return x < 0 || x >= N || y < 0 || y >= M;
        }

        static void search(int x, int y, int sum){
            if(x == N) {
                ans = Math.max(ans, sum);
                return ;
            }
            if(!visited[x][y]){
                visited[x][y] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(outOfMap(x, ny))continue;
                    if(outOfMap(nx, y))continue;
                    if(visited[x][ny])continue;
                    if(visited[nx][y])continue;
                    visited[nx][y] = true;
                    visited[x][ny] = true;
                    if(y == M - 1) search(x + 1, 0, sum + 2 * map[x][y] + map[nx][y] + map[x][ny]);
                    else search(x, y + 1, sum + 2 * map[x][y] + map[nx][y] + map[x][ny]);
                    visited[nx][y] = false;
                    visited[x][ny] = false;
                }
                visited[x][y] = false;
            }

            if(y == M - 1) search(x + 1, 0, sum);
            else search(x, y + 1, sum);
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            search(0, 0, 0);
            System.out.println(ans);
        }
    }
