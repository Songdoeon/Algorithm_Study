import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2758 - 08:28 시작

public class Main {
    static int T, N, M;
    static long[][] dp;

    static long search(int n, int m){
        if (m <= 0) return 0;
        if (n == 1) return m;     
        if (dp[n][m] != -1) return dp[n][m];
        
        return dp[n][m] = search(n, m - 1) + search(n - 1, m / 2);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        
        dp = new long[11][2001];

        for (long[] row : dp) Arrays.fill(row, -1);

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(search(N, M)).append('\n');
        }

        System.out.println(sb);
    }
}
