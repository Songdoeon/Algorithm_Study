import java.io.*;
import java.util.*;

// 5913 : 17:00 시작

public class Main {
    static int N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 25;
    static int[][] map;
    static boolean[][] visited;
    static int ans = 0;
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= 5 || y < 0 || y >= 5;
    }
    static void search(int x1, int y1, int x2, int y2, int sum){
        if(x1 == x2 && y1 == y2){
            if(count == sum) ans++;
            return ;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x1 + dx[i];
            int ny = y1 + dy[i];
            if(outOfMap(nx, ny))continue;
            if(visited[nx][ny])continue;
            visited[nx][ny] = true;
            for (int j = 0; j < 4; j++) {
                int nx2 = x2 + dx[j];
                int ny2 = y2 + dy[j];
                if(outOfMap(nx2, ny2))continue;
                if(nx == nx2 && ny == ny2) {
                    search(nx, ny, nx2, ny2, sum + 1);
                    continue;
                }
                if(visited[nx2][ny2])continue;
                visited[nx2][ny2] = true;
                search(nx2, ny2, nx, ny, sum + 2);
                visited[nx2][ny2] = false;
            }
            visited[nx][ny] = false;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        count -= N;
        map = new int[5][5];
        visited = new boolean[5][5];
        visited[0][0] = true;
        visited[4][4] = true;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            visited[x][y] = true;
        }

        search(0, 0, 4, 4, 2);

        System.out.println(ans);
    }
}

