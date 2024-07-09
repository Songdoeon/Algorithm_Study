import java.io.*;
import java.sql.Array;
import java.util.*;

class Pos{
    int x, y, d;

    public Pos(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
public class Main {
    static int N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans = 0;
    static char[][] map;
    static boolean outOfMap(int x, int y){
        return x < 0 || y < 0 || x >= N || y >= N;
    }

    static void search(int x, int y, int dis){
        int sX = x - dis;
        int sY = y - dis;
        int eX = x + dis;
        int eY = y + dis;

        if(outOfMap(sX, sY)) return ;
        if(outOfMap(eX, eY)) return ;
        for (int i = sX; i <= eX; i++) {
            if((i == x && map[i][sY] == '0') || (i != x && map[i][sY] == '1')) return ;
            if((i == x && map[i][eY] == '0') || (i != x && map[i][eY] == '1')) return ;
        }
        for (int i = sY; i <= eY; i++) {
            if((i == y && map[sX][i] == '0') || (i != y && map[sX][i] == '1')) return ;
            if((i == y && map[eX][i] == '0') || (i != y && map[eX][i] == '1')) return ;
        }
        ans++;
        search(x, y, dis + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Queue<Pos> queue = new ArrayDeque<>();
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if(map[i][j] == '1') {
                    search(i, j, 1);

                }
            }
        }
        System.out.println(ans);
    }
}