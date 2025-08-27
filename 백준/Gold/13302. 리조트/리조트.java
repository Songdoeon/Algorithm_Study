import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1715

public class Main {
    static int N, M;
    static boolean[] closed;      // 휴장일 표시
    static int[][] dp;            // dp[day][coupon] = day부터의 최소비용
    static final int INF = 1_000_000_000;

    static int search(int day, int coupon){
        if (day > N) return 0;
        if (dp[day][coupon] != -1) return dp[day][coupon];

        int ret = INF;
        if (closed[day]) {
            ret = search(day + 1, coupon);
        } else {
            ret = Math.min(ret, 10_000 + search(day + 1, coupon));
            ret = Math.min(ret, 25_000 + search(day + 3, coupon + 1));
            ret = Math.min(ret, 37_000 + search(day + 5, coupon + 2));
            if (coupon >= 3) ret = Math.min(ret, search(day + 1, coupon - 3));
        }
        return dp[day][coupon] = ret;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        closed = new boolean[N + 1];
        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int d = Integer.parseInt(st.nextToken());
                closed[d] = true;
            }
        }

        dp = new int[N + 1][41];
        for (int i = 0; i <= N; i++) Arrays.fill(dp[i], -1);

        System.out.println(search(1, 0));
    }
}