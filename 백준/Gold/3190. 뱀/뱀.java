import java.io.*;
import java.util.*;
class Pos{
    int x, y;

    public Pos(int x, int y){
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
class Main {
    static int N, M, K;
    static int[] dx = {0, 1 , 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Set<Pos> set = new HashSet<>();
    static Deque<Pos> path = new ArrayDeque<>();
    static int[] times;
    static String[] dirs;
    static boolean isOvered(int x, int y){
        if(x < 1 || x > N || y < 1 || y > N) return true;
        return path.contains(new Pos(x, y));
    }
    static boolean ateApple(int x, int y){
        Pos p = new Pos(x, y);
        if(set.contains(p)){
            set.remove(p);
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            set.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        path.add(new Pos(1, 1));
        int M = Integer.parseInt(br.readLine());
        times = new int[M];
        dirs = new String[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            dirs[i] = st.nextToken();
        }


        int dir = 0;
        int ans = 1;
        int idx = 0;
        while (true){
            Pos p = path.peekFirst();
            int nx = p.x + dx[dir];
            int ny = p.y + dy[dir];

            if(isOvered(nx, ny))break;
            path.offerFirst(new Pos(nx, ny));

            if(!ateApple(nx, ny)) path.pollLast();

            if(ans++ == times[idx]){
                if(dirs[idx].equals("D")) dir = (dir + 1) % 4;
                else dir = dir - 1;
                if(dir < 0) dir = 3;
                if(idx < M - 1)idx++;
            }
        }
        System.out.println(ans);

    }
}
