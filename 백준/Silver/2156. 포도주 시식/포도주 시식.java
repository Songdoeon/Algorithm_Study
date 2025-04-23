import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] arr;
    static int[][] dp;
    static int search(int idx, int depth){
        if(idx >= N) return 0;
        if(dp[idx][depth] != -1){
            return dp[idx][depth];
        }
        dp[idx][depth] = -1;
        if(depth == 1) dp[idx][depth] = Math.max(search(idx + 2, 0) + arr[idx], search(idx + 1, 0));
        else dp[idx][depth] = Math.max(search(idx + 1, 0), search(idx + 1, depth + 1) + arr[idx]);

        return dp[idx][depth];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            Arrays.fill(dp[i], -1);
        }
        System.out.println(search(0, 0));
    }
}
