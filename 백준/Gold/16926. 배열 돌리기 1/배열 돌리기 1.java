import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean outOfMap(int x, int y, int i){
        return x < i || x >= N - i || y < i || y >= M - i;
    }
    static void rotate(){
        while(R-- > 0){
            int layer = Math.min(N, M) / 2;
            for (int i = 0; i < layer; i++) {
                int prev = map[i][i];
                int x = i, y = i;

                for (int j = 0; j < 4; j++) {
                    while (true){
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if(outOfMap(nx, ny, i))break;
                        int temp = map[nx][ny];
                        map[nx][ny] = prev;
                        prev = temp;
                        x = nx;
                        y = ny;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotate();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
