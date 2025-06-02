import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11261

public class Main {
    static int T, N, M;
    static int[] W, H;
    static int[][] dp;
    static int search(int idx, int total) {
        if (idx == N) return 0;
        if (total <= 0) return 0;

        if (dp[idx][total] != -1) {
            return dp[idx][total];
        }

        int ret = 0;
        if (total - W[idx] >= 0) {
            ret = H[idx] + search(idx + 1, total - W[idx]);
        }

        int skip = search(idx + 1, total);

        return dp[idx][total] = Math.max(ret, skip);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            W = new int[N];
            H = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                W[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                H[i] = Integer.parseInt(st.nextToken());
            }
            dp = new int[N + 1][M + 1];
            for (int i = 0; i <= N; i++) {
                Arrays.fill(dp[i], -1);
            }
            sb.append(search(0, M)).append('\n');
        }
        System.out.println(sb);
    }
}