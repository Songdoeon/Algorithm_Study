
import java.util.*;
import java.io.*;
class Pos{
    int x,y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, T;
    static int[][] map, tempMap;
    static Pos up, down;
    static int ans = 0;

    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    static void extend(int x, int y){
        if(map[x][y] == -1) {
            tempMap[x][y] = -1;
            return ;
        }
        int value = map[x][y];
        int amount = value / 5;
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(outOfMap(nx, ny) || map[nx][ny] == -1) continue;
            cnt++;
            tempMap[nx][ny] += amount;
        }
        tempMap[x][y] += value - cnt * amount;
    }

    static void rotate(){
        int x = up.x - 1;
        int y = up.y;
        for (int i = 6; i > 2; i--) {
            int nx = x;
            int ny = y;
            if(map[nx][ny] == -1) break;
            while (!outOfMap(x, y)){
                nx = x + dx[i % 4];
                ny = y + dy[i % 4];

                if(outOfMap(nx, ny)) break;
                if(map[nx][ny] == -1) {
                    map[x][y] = 0;
                    break;
                }
                if(x > up.x){
                    x = up.x;
                    break;
                }

                map[x][y] = map[nx][ny];
                x = nx;
                y = ny;
            }
        }
        x = down.x + 1;
        y = down.y;

        for (int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;
            if(map[nx][ny] == -1) break;
            while (!outOfMap(x, y)){
                nx = x + dx[i % 4];
                ny = y + dy[i % 4];
                if(outOfMap(nx, ny)) break;
                if(map[nx][ny] == -1) {
                    map[x][y] = 0;
                    break;
                }
                if(x < down.x){
                    x = down.x;
                    break;
                }
                map[x][y] = map[nx][ny];
                x = nx;
                y = ny;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        up = null;
        down = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1 && up == null) {
                    up = new Pos(i, j);
                    down = new Pos(i + 1, j);
                }
            }
        }
        while (T -- > 0){
            tempMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    extend(i, j);
                }
            }
            map = tempMap;
            rotate();

        }
        ans = Arrays.stream(map).flatMapToInt(Arrays::stream).sum();

        System.out.println(ans + 2);
    }
}
