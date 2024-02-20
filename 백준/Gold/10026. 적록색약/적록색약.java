import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        int ans = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<int[]> queue2 = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        boolean[][] visited2 = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    char c = map[i][j];
                    ans++;
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()){
                        int[] p = queue.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = p[0] + dx[k];
                            int ny = p[1] + dy[k];
                            if(outOfMap(nx, ny) || c != map[nx][ny] || visited[nx][ny]) continue;
                            visited[nx][ny] = true;
                            queue.offer(new int[] {nx, ny});
                        }
                    }
                }
            }
        }
        System.out.print(ans + " ");
        ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited2[i][j]){
                    char c = map[i][j];
                    ans++;
                    queue2.offer(new int[] {i, j});
                    visited2[i][j] = true;
                    while (!queue2.isEmpty()){
                        int[] p = queue2.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = p[0] + dx[k];
                            int ny = p[1] + dy[k];

                            if(outOfMap(nx, ny) || visited2[nx][ny]) continue;
                            if((c == 'R' && map[nx][ny] == 'B') || (c == 'G' && map[nx][ny] == 'B')) continue;
                            if(c == 'B' && map[nx][ny] != 'B') continue;
                            visited2[nx][ny] = true;
                            queue2.offer(new int[] {nx, ny});
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
