import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 19238 - 스타트 택시

class Pos {
    int x, y, k; // k는 여기서 "거리"로 사용
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
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= N;
    }


    static int search(Pos p1, Pos p2){
        Queue<Pos> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        q.offer(new Pos(p1.x, p1.y, 0));
        visited[p1.x][p1.y] = true;

        while(!q.isEmpty()){
            Pos cur = q.poll();
            if(cur.x == p2.x && cur.y == p2.y) return cur.k;
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(outOfMap(nx, ny)) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 1) continue;
                visited[nx][ny] = true;
                q.offer(new Pos(nx, ny, cur.k + 1));
            }
        }
        return -1;
    }

    static Pos nearestSearch(Pos p){
        Queue<Pos> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        q.offer(new Pos(p.x, p.y, 0));
        visited[p.x][p.y] = true;

        while(!q.isEmpty()){
            int size = q.size();
            PriorityQueue<Pos> candidates = new PriorityQueue<>((a, b) -> {
                if (a.x != b.x) return a.x - b.x;
                return a.y - b.y;
            });

            while(size-- > 0){
                Pos cur = q.poll();
                if(map[cur.x][cur.y] > 1) candidates.offer(cur); 
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(outOfMap(nx, ny)) continue;
                    if(visited[nx][ny]) continue;
                    if(map[nx][ny] == 1) continue;
                    visited[nx][ny] = true;
                    q.offer(new Pos(nx, ny, cur.k + 1));
                }
            }
            if(!candidates.isEmpty()) return candidates.poll();
        }
        return new Pos(-1, -1, -1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
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
        int taxiX = Integer.parseInt(st.nextToken()) - 1;
        int taxiY = Integer.parseInt(st.nextToken()) - 1;
        int fuel  = K;

        info = new Pos[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            Pos start = new Pos(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);
            Pos dest  = new Pos(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);

            dest.k = search(start, dest);
            map[start.x][start.y] = i + M + 1; 
            info[i] = dest; 
        }

        for (int served = 0; served < M; served++) {

            Pos nearest = nearestSearch(new Pos(taxiX, taxiY, 0));
            if (nearest.x == -1) { System.out.println(-1); return; }

            int distToPickup = nearest.k;
            if (fuel < distToPickup) { System.out.println(-1); return; }
            fuel -= distToPickup;

            int idx = map[nearest.x][nearest.y] - M - 1;
            Pos destination = info[idx];
            map[nearest.x][nearest.y] = 0;

            if (destination.k == -1) { System.out.println(-1); return; }
            if (fuel < destination.k) { System.out.println(-1); return; }

            fuel = fuel - destination.k + (destination.k * 2);

            taxiX = destination.x;
            taxiY = destination.y;
        }

        System.out.println(fuel);
    }
}
