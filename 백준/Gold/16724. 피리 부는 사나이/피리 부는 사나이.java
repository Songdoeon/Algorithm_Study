import java.io.*;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
class Pos{
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pos pos = (Pos) o;
        return x == pos.x && y == pos.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] cycle;
    static char calc(Pos p){
        char dir = map[p.x][p.y];
        if(dir == 'D') return 1;
        if(dir == 'L') return 2;
        if(dir == 'R') return 3;
        return 0;
    }
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        Set<Pos> set = new HashSet<>();
        cycle = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        Queue<Pos> queue = new ArrayDeque<>();
        visited = new boolean[N][M];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j]) continue;
                set = new HashSet<>();
                set.add(new Pos(i, j));
                queue.add(new Pos(i, j));
                while (!queue.isEmpty()) {
                    Pos p = queue.poll();
                    int idx = calc(p);

                    int nx = p.x + dx[idx];
                    int ny = p.y + dy[idx];
                    if(visited[nx][ny]) {
                        for (Pos pos : set) {
                            visited[pos.x][pos.y] = true;
                        }
                        break;
                    }
                    if(set.contains(new Pos(nx, ny))){
                        for (Pos pos : set) {
                            visited[pos.x][pos.y] = true;
                        }
                        ans++;
                        break;
                    }
                    set.add(new Pos(nx, ny));
                    queue.add(new Pos(nx, ny));
                }
            }
        }
        System.out.println(ans);
    }
}