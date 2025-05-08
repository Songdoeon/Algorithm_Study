import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1495 - 10:53

public class Main {
    static int N, S, max;
    static int[] arr;
    static int[][] dp;
    static int search(int idx, int volume){
        if(idx == N) return volume;
        if(dp[idx][volume] != -2) return dp[idx][volume];

        int ret = -1;

        int m = volume - arr[idx];
        int M = volume + arr[idx];
        if(M <= max) ret = search(idx + 1, M);
        if(m >= 0) ret = Math.max(ret, search(idx + 1, m));
        return dp[idx][volume] = ret;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[N][max + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -2);
        }
        System.out.println(search(0, S));
    }
}
