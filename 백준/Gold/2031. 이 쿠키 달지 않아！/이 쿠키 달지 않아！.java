import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T, N, D, K;
    static int[] a;     
    static int[] p, cnt;   
    static int[][] dp;   


    static int lowerBound(int[] arr, int l, int r, int key) {
        int lo = l, hi = r; // [lo, hi)
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] >= key) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        a = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a, 1, N + 1);

        p = new int[N + 1];
        cnt = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int lb = lowerBound(a, 1, N + 1, a[i] - D + 1);
            p[i] = lb - 1;             
            if (p[i] < 0) p[i] = 0;
            cnt[i] = i - p[i];         
        }

        if (K > N) K = N;
        dp = new int[K + 1][N + 1];  

        for (int j = 1; j <= K; j++) {
            for (int i = 1; i <= N; i++) {
                int take = cnt[i] + dp[j - 1][i - cnt[i]];
                int skip = dp[j][i - 1];
                dp[j][i] = (take >= skip) ? take : skip;
            }
        }
        System.out.println(dp[K][N]);
    }
}
