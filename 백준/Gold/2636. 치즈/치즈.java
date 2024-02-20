import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0 ,0};
    static int[] dy = {0, 0, 1, -1};

    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];

        Queue<int[]> queue = new ArrayDeque<>();
        Queue<int[]> tempQueue = new ArrayDeque<>();
        int cheese = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if(st.nextToken().equals("0")) {
                    map[i][j] = true;
                }
                else {
                    cheese++;
                    map[i][j] = false;
                }
            }
        }

        visited = new boolean[N][M];
        tempQueue.add(new int[] {0, 0});
        queue.add(new int[] {0, 0});
        int time = 0;
        int lastCheese = cheese;
        visited[0][0] = true;
        while(true){
            time++;
            while(!tempQueue.isEmpty()){
                int[] p = tempQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = p[0] + dx[i];
                    int ny = p[1] + dy[i];
                    if (outOfMap(nx, ny) || !map[nx][ny]) continue;
                    if(visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    tempQueue.add(new int[]{nx, ny});
                    queue.add(new int[] {nx, ny});
                }
            }
            
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = p[0] + dx[i];
                    int ny = p[1] + dy[i];
                    if (outOfMap(nx, ny) || map[nx][ny]) continue;
                        map[nx][ny] = true;
                        cheese--;
                        tempQueue.add(new int[] {nx, ny});
                        queue.add(new int[]{nx, ny});
                    }
                }
            if(cheese == 0) break;
            lastCheese = cheese;
        }
        System.out.println(time);
        System.out.println(lastCheese);
    }
}
