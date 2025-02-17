import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
    int x, y, d;
    StringBuilder sb;
    public Pos(int x, int y, int d, StringBuilder sb) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.sb = new StringBuilder(sb);
    }
    public void add(char c){
        sb.append(c);
    }
}
class Main {
    static int N, M, K;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};
    static char[][] map;

    static Pos calc(int x, int y, int d, StringBuilder sb){
        int nx = x;
        int ny = y;
        if(x < 0) nx = N - 1;
        else if(x == N) nx = 0;
        if(y < 0) ny = M - 1;
        else if(y == M) ny = 0;
        return new Pos(nx, ny, d, sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> hash = new HashMap<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        Queue<Pos> queue;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                Pos p = new Pos(i, j, 1, new StringBuilder());
                p.add(map[i][j]);
                hash.put(String.valueOf(map[i][j]), hash.getOrDefault(String.valueOf(map[i][j]), 0) + 1);
                queue = new ArrayDeque<>();
                queue.add(p);
                while(!queue.isEmpty()){
                    Pos pos = queue.poll();
                    if(pos.d > 5) continue;
                    boolean[][] visited = new boolean[N][M];
                    for(int d = 0; d < 8; d++){
                        int nx = pos.x + dx[d];
                        int ny = pos.y + dy[d];
                        Pos np = calc(nx, ny, pos.d + 1, pos.sb);
                        if(visited[np.x][np.y])continue;
                        visited[np.x][np.y] = true;
                        np.add(map[np.x][np.y]);
                        hash.put(np.sb.toString(), hash.getOrDefault(np.sb.toString(), 0) + 1);
                        queue.add(np);
                    }
                }
            }
        }

        for (int i = 0; i < K; i++) {
            sb.append(hash.getOrDefault(br.readLine(), 0)).append('\n');
        }
        System.out.println(sb);
    }
}
