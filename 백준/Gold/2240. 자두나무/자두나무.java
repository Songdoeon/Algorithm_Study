import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Wood{
    int tree;
    int cnt;

    public Wood(int tree, int cnt) {
        this.tree = tree;
        this.cnt = cnt;
    }
}
public class Main {
    static int N, M;
    static Wood[] woods;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int[][][] dp = new int[M + 1][2][N + 1];
        woods = new Wood[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }

        if(arr[0] == 0) {
            dp[0][0][1] = 1;
        }
        else{
            dp[1][1][1] = 1;
        }

        for (int i = 2; i <= N; i++) {
            int n = arr[i - 1];

            if(n == 0) {
                dp[0][0][i] = dp[0][0][i - 1] + 1;
                dp[0][1][i] = dp[0][1][i - 1];
            }
            else {
                dp[0][0][i] = dp[0][0][i - 1];
                dp[0][1][i] = dp[0][1][i - 1] + 1;
            }

            for (int j = 1; j <= M; j++) {
                if(n == 0) {
                    dp[j][0][i] = Math.max(dp[j][0][i - 1], dp[j - 1][1][i - 1]) + 1;
                    dp[j][1][i] = Math.max(dp[j][1][i - 1], dp[j - 1][0][i - 1]);
                }
                else {
                    dp[j][0][i] = Math.max(dp[j][0][i - 1], dp[j - 1][1][i - 1]);
                    dp[j][1][i] = Math.max(dp[j][1][i - 1], dp[j - 1][0][i - 1]) + 1;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i <= M; i++) {
            for (int j = 0; j < 2; j++) {
                ans = Math.max(ans, dp[i][j][N]);
            }
        }

        System.out.println(ans);
    }
}