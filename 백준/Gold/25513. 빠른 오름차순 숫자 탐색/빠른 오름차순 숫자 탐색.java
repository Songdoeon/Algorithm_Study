import java.io.*;
import java.util.*;

class Pos{
    int x, y;
    int find;
    Pos(int x, int y, int find){
        this.x = x;
        this.y = y;
        this.find = find;
    }
}
class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][] visited = new boolean[5][5][6];
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= 5 || y < 0 || y >= 5;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        Pos start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1);
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(start);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int s = 0; s < size; s++) {
                Pos p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];
                    if(outOfMap(x, y)) continue;
                    if(visited[x][y][p.find - 1])continue;
                    if(map[x][y] == -1) continue;
                    if(p.find == 6 && map[x][y] == 6) {
                        System.out.println(ans);
                        return ;
                    }
                    if(map[x][y] == p.find){
                        visited[x][y][p.find] = true;
                        queue.add(new Pos(x, y, p.find + 1));
                    }
                    else{
                        visited[x][y][p.find - 1] = true;
                        queue.add(new Pos(x, y, p.find));
                    }
                }
            }
        }
        System.out.println(-1);
    }
}