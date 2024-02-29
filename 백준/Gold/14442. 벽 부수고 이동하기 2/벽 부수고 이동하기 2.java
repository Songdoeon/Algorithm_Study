import java.io.*;
import java.util.*;

class Wall{
    int x;
    int y;
    int broken;
    int cnt;
    Wall(int x, int y, int broken, int cnt){
        this.x = x;
        this.y = y;
        this.broken = broken;
        this.cnt = cnt;
    }
}
public class Main {
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1 , 0, -1};
    static int N, M, K;
    static int[][] map;
    static boolean[][][] visited;

    static boolean outOfMap(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    public static void main(String[] args) throws IOException {
        Queue<Wall> queue = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M][K + 1];
//        for(int i = 0; i <= K; i++){
//            visited[0][0][i] = true;
//        }
        visited[0][0][0] = true;
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        int answer = -1;
        queue.add(new Wall(0, 0, 0, 1));
        while(!queue.isEmpty()) {
            Wall cur = queue.poll();
            if (cur.x == N - 1 && cur.y == M - 1) {
                System.out.println(cur.cnt);
                return ;
            }
            for(int i = 0; i < 4; i++) {
                int cX = cur.x + dx[i];
                int cY = cur.y + dy[i];
                if(outOfMap(cX, cY)) continue;
                int cnt = cur.cnt + 1;
                if(map[cX][cY] == 0 && !visited[cX][cY][cur.broken]) {
                    queue.add(new Wall(cX, cY, cur.broken, cnt));
                    visited[cX][cY][cur.broken] = true;
                }
                else if (map[cX][cY] == 1 && cur.broken < K && !visited[cX][cY][cur.broken + 1] ) {
                    queue.add(new Wall(cX, cY, cur.broken + 1, cnt));
                    visited[cX][cY][cur.broken + 1] = true;
                }

            }
        }
        System.out.println(answer);
    }
}