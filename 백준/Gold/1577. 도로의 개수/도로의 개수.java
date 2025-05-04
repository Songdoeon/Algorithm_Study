import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

// 1577 - 02:23 시작

class Const{
    int a, b, c, d;

    public Const(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Const)) return false;
        Const aConst = (Const) o;
        return a == aConst.a && b == aConst.b && c == aConst.c && d == aConst.d;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }
}
public class Main {
    static int N, M, K;
    static int[] dx = {-1, 0};
    static int[] dy = {0, -1};
    static long[][] dp;
    static Set<Const> set = new HashSet<>();
    static long search(int x, int y){
        if(x == 0 && y == 0) return 1;
        if(dp[x][y] != -1) return dp[x][y];

        long ret = 0;

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(outOfMap(nx, ny)) continue;
            if(set.contains(new Const(nx, ny, x, y))) continue;
            ret += search(nx, ny);
        }

        return dp[x][y] = ret;
    }
    static boolean outOfMap(int x, int y){
        return x < 0 || x > N || y < 0 || y > M;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        dp = new long[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            set.add(new Const(a, b, c, d));
            set.add(new Const(c, d, a, b));
        }

        System.out.println(search(N, M));
    }
}

