import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 31963 - 17:00 시작

public class Main {
    static int N, M;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static boolean[][] visited;
    static int[][] map;

    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    static void search(int x, int y){
        if(x == N - 1 && y == M - 1) {
            System.out.println("Yes");
            System.exit(0);
        }
        
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(outOfMap(nx, ny)) continue;
            if(map[nx][ny] == 0) continue;
            if(visited[nx][ny]) continue;
            visited[x][y] = true;
            search(nx, ny);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        search(0, 0);
        System.out.println("No");
    }
}