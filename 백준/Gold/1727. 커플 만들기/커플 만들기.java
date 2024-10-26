import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[] mans, girls;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mans = new int[N];
        girls = new int[M];
        int[][] dp = new int[N + 1][M + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            mans[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            girls[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(mans);
        Arrays.sort(girls);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int num = Math.abs(mans[i - 1] - girls[j - 1]);
                if(i == j) dp[i][j] = dp[i - 1][j - 1] + num;
                else if(i < j) dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j - 1] + num);
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1] + num);
            }
        }
        System.out.println(dp[N][M]);
    }
}