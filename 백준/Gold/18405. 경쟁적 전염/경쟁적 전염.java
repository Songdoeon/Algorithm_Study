import java.util.*;
import java.io.*;
class Pos{
    int no, x, y;

    public Pos(int no, int x, int y) {
        this.no = no;
        this.x = x;
        this.y = y;
    }
}
class Main {
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0 , 1};
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= N;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        Queue<Pos> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.no));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) queue.offer(new Pos(map[i][j], i, j));
            }
        }
        Queue<Pos> queue2 = new ArrayDeque<>();
        
        while (!queue.isEmpty()){
            queue2.offer(queue.poll());
        }


        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        if(queue2.isEmpty()){
            System.out.println(map[x - 1][y - 1]);
            return ;
        }
        while (t-- > 0){
            int size = queue2.size();
            while (size-- > 0){
                Pos p = queue2.poll();
                if(p.x == x - 1 && p.y == y - 1){
                    System.out.println(map[x - 1][y - 1]);
                    return ;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    if(outOfMap(nx, ny))continue;
                    if(map[nx][ny] != 0) continue;
                    map[nx][ny] = map[p.x][p.y];
                    queue2.offer(new Pos(map[nx][ny], nx, ny));
                }
            }
        }
        System.out.println(map[x - 1][y - 1]);
    }
}