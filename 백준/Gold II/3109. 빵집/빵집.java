import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static int R, C;
    static char[][] map;
    static int ans = 0;
    static boolean[][] visited;
    static int max;
    static boolean[] starts;
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= R || y < 0 || y >= C;
    }
    static boolean search(int x, int y){

        if(y == C - 1){
            ans++;
            return true;
        }
        for(int i = 0; i < 3; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(outOfMap(nx, ny) || map[nx][ny] == 'x') continue;
            if(visited[nx][ny]) continue;
            visited[nx][ny] = true;

            if(search(nx, ny)) return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        String s;
        map = new char[R][C];
        visited = new boolean[R][C];
        max = R;
        starts = new boolean[R];
        for(int i = 0; i < R; i++){
            s = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = s.charAt(j);
            }
        }
        search(0,0);
        for(int i = 0; i < R; i++){
            search(i, 0);
        }
        System.out.println(ans);
    }
}
