

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

class Pos{
    int x, y, cost;

    public Pos(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}
public class Solution {

    static int T, N, result;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] visited;
    static StringBuilder sb = new StringBuilder();
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(visited[i], 100_000_000);
            }
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }
            Queue<Pos> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
            queue.offer(new Pos(0, 0, 0));

            while (!queue.isEmpty()){

                Pos p = queue.poll();
//                System.out.println(p.x + " : " + p.y);
                if(p.x == N - 1 && p.y == N - 1){
                    sb.append("#").append(t).append(" ").append(p.cost).append("\n");
                }
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];

                    if(outOfMap(nx, ny)) continue;
                    if(visited[nx][ny] > (p.cost + map[nx][ny]) ){
                        visited[nx][ny] = p.cost + map[nx][ny];
                        queue.offer(new Pos(nx, ny, visited[nx][ny]));
                    }
                }
            }

        }
        System.out.println(sb);
    }

}
