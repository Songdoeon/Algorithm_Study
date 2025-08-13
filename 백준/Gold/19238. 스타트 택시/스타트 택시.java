import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 19238

class Pos{
    int x, y, k;
    public Pos(int x, int y, int k){
        this.x = x;
        this.y = y;
        this.k = k;
    }

}
public class Main {
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int N, M, K;
    static int[][] map;
    static Pos[] info;

    static int search(Pos p1, Pos p2){
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        queue.offer(p1);
        visited[p1.x][p1.y] = true;

        while(!queue.isEmpty()){
            Pos cur = queue.poll();
            if(cur.x == p2.x && cur.y == p2.y){
                return cur.k;
            }
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(outOfMap(nx, ny))continue;
                if(visited[nx][ny])continue;
                if(map[nx][ny] == 1)continue;
                visited[nx][ny] = true;
                queue.offer(new Pos(nx, ny, cur.k + 1));
            }
        }

        return -1;
    }

    static Pos nearestSearch(Pos p){
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        queue.offer(new Pos(p.x, p.y, 0));
        visited[p.x][p.y] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            Queue<Pos> temp = new PriorityQueue<>((o1, o2) -> o1.x == o2.x ? o1.y - o2.y : o1.x - o2.x);
            while(size-- > 0){
                Pos cur = queue.poll();
                if(map[cur.x][cur.y] > 1) temp.offer(cur);
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(outOfMap(nx, ny))continue;
                    if(visited[nx][ny])continue;
                    if(map[nx][ny] == 1)continue;
                    visited[nx][ny] = true;
                    queue.offer(new Pos(nx, ny, cur.k + 1));
                }
            }
            if(!temp.isEmpty()) return temp.poll();
        }

        return new Pos(-1, -1, -1);
    }

    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= N;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        Pos start = new Pos(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, K);
        info = new Pos[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());


            Pos p1 = new Pos(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);
            Pos p2 = new Pos(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);

            p2.k = search(p1, p2);
            map[p1.x][p1.y] = i + M + 1;
            info[i] = p2;
        }

        Queue<Pos> queue = new ArrayDeque<>();

        queue.offer(start);

        int ans = -1;
        for (int i = 0; i < M; i++) {
            Pos cur = queue.poll();
            Pos nearest = nearestSearch(cur);
            if(nearest.x == -1 && nearest.y == -1) break;
//
            int idx = map[nearest.x][nearest.y] - M - 1;
            Pos destination = info[idx];
            if(destination.k == -1)break;

            cur.k -= nearest.k;

            if(destination.k > cur.k) break;
            if(i == M - 1) ans = cur.k + destination.k;
            queue.offer(new Pos(destination.x, destination.y, cur.k + destination.k));
            map[nearest.x][nearest.y] = 0;
        }

        System.out.println(ans);

    }
}
