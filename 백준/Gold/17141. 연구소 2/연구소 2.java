import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 09:49 시작

class Pos{
    int x, y, t;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
        this.t = 0;
    }

    public Pos(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

class Main{
    static int N, M;
    static int[][] map;
    static Pos[] virous;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0 , -1};
    static boolean[][] visited;
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= N || visited[x][y];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        virous = new Pos[10];
        int v = 0;
        int total = N * N - M;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virous[v++] = new Pos(i, j);
                }
                else if(map[i][j] == 1)total--;
            }
        }
        if(total <= 0){
            System.out.println(0);
            return ;
        }
        Queue<Pos> queue;
        int count = 1 << v;
        int ans = N * N + 1;
        for (int i = 0; i < count; i++) {
            if(Integer.bitCount(i) == M){
                queue = new ArrayDeque<>();
                visited = new boolean[N][N];
                for (int j = 0; j < v; j++) {
                    if((i & 1 << j) > 0) {
                        queue.add(new Pos(virous[j].x, virous[j].y, 0));
                        visited[virous[j].x][virous[j].y] = true;
                    }
                }
                int temp = 0;

                if(total <= temp){
                    System.out.println(0);
                    return ;
                }
                while (!queue.isEmpty()) {
                    Pos pos = queue.poll();
                    for (int d = 0; d < 4; d++) {
                        int nx = pos.x + dx[d];
                        int ny = pos.y + dy[d];
                        if (outOfMap(nx, ny)) continue;
                        if (map[nx][ny] == 1) continue;
                        visited[nx][ny] = true;
                        temp++;
                        if(total == temp){
                            ans = Math.min(ans, pos.t + 1);
                            break;
                        }
                        queue.offer(new Pos(nx, ny, pos.t + 1));
                    }
                }
            }
        }
        System.out.println(ans == N * N + 1 ? -1 : ans);
    }
}