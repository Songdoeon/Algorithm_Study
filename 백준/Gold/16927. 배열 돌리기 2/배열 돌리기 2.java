import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static StringBuilder sb = new StringBuilder();
    static boolean outOfMap(int x, int y, int d){
        return x < d || x >= N - d || y < d || y >= M - d;
    }
    static void rotate(){
        int layer = Math.min(N, M) / 2;
        for (int l = 0; l < layer; l++) {
            int t = R % ((N - (l * 2)) * 2 + (M - (l * 2) - 2) * 2);
//            System.out.println(((N - (l * 2)) * 2 + (M - (l * 2) - 2) * 2));
            while (t-- > 0){
                int prev = map[l][l];
                int x = l, y = l;
                for (int d = 0; d < 4; d++) {
                    while(true){
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if(outOfMap(nx, ny, l))break;
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
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}