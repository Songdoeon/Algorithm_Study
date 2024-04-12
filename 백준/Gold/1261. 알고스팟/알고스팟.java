import java.io.*;
import java.util.*;
class Pos{
    int x, y, broken;

    public Pos(int x, int y, int broken) {
        this.x = x;
        this.y = y;
        this.broken = broken;
    }
}
class Main {
    static int N, M;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Deque<Pos> queue = new ArrayDeque<>();
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        queue.offerFirst(new Pos(0, 0, 0));

        while (!queue.isEmpty()){
            Pos p = queue.pollFirst();
            if(p.x == N - 1 && p.y == M - 1){
                System.out.println(p.broken);
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if(outOfMap(nx, ny))continue;
                if(visited[nx][ny])continue;
                visited[nx][ny] = true;
                if(map[nx][ny] == '1')queue.offerLast(new Pos(nx, ny, p.broken + 1));
                else queue.offerFirst(new Pos(nx, ny, p.broken));
            }
        }
        System.out.println("??");
    }
}