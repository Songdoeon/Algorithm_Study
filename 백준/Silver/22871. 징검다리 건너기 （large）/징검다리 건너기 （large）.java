import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[] arr;
    static long[] dp;
    static long INF = 50_000_000_001L;
    static long cost(int i, int j) {
        long diff = Math.abs(arr[i] - arr[j]);
        return (j - i) * (1 + diff);
    }


    static long dfs(int idx) {
        if (idx == N - 1) return 0;

        if (dp[idx] != -1) return dp[idx];

        long ans = INF;

        for (int j = idx + 1; j < N; j++) {
            long jumpCost = cost(idx, j);
            long candidate = Math.max(jumpCost, dfs(j));
            ans = Math.min(ans, candidate);
        }
        dp[idx] = ans;
        return ans;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new long[N];
        Arrays.fill(dp, -1);
        System.out.println(dfs(0));
    }
}
