import java.util.*;
import java.io.*;

class Pos{
    int x, y, k;
    int sum;

    public Pos(int x, int y, int k, int sum) {
        this.x = x;
        this.y = y;
        this.k = k;
        this.sum = sum;
    }
}
class Main{
    static int[] dx = {1, 0, -1 ,0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M;
    static int[][] map;
    static int result;
    static boolean[][] visited;
    static int exclude(int i, int j, int sum){
        int min = 1000;
        int idx = 0;
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(outOfMap(nx, ny)) continue;
            idx++;
            sum += map[nx][ny];
            min = Math.min(map[nx][ny], min);
        }
        if(idx == 4) return sum - min;
        return sum;
    }
    static void search(int i, int j, int k, int sum){
        if(k == 4) {
            result = Math.max(result, sum);
            return ;
        }
        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if(outOfMap(nx, ny)) continue;
            if(visited[nx][ny]) continue;
            visited[nx][ny] = true;
            search(nx, ny, k + 1, sum + map[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    static boolean outOfMap(int x, int y){
        return x < 1 || x > N || y < 1 || y > M;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N + 2][M + 2];
        result = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                visited[i][j] = true;
                search(i, j, 1, map[i][j]);
                result = Math.max(result, exclude(i, j, map[i][j]));
                visited[i][j] = false;
            }
        }

        System.out.println(result);
    }
}
