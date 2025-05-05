import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 16132 - 08:35 시작

public class Main {
    static int N;
    static long[][] dp;
    static int target;
    static long search(int idx, int num){
        if(idx > N) return 0;
        if(idx == N && num == 0) return 1;
        if(num < 0) return 0;
        if(dp[idx][num] != -1) return dp[idx][num];

        return dp[idx][num] = search(idx + 1, num) + search(idx + 1, num - idx);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        target = 0;
        for (int i = 1; i <= N; i++) {
            target += i;
        }
        if(target % 2 == 1){
            System.out.println(0);
            return ;
        }
        target /= 2;
        dp = new long[N + 1][target + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(search(1, target));
    }
}