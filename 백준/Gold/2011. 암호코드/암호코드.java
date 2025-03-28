import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//11:04 시작
class Main {
    static int N;
    static char[] arr;
    static int[] dp;
    static final int MOD = 1_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        int len = arr.length;
        dp = new int[len + 1];
        dp[len] = 1;
        if(arr[len - 1] != '0')dp[len - 1]++;
        for (int i = len - 2; i >= 0; i--) {
            if(arr[i] == '0'){
                if(i == 0 || arr[i - 1] >= '3' || arr[i + 1] == '0'){
                    System.out.println(0);
                    return ;
                }
                continue;
            }
            if(arr[i + 1] <= '6' && arr[i] <= '2' && arr[i] != '0'){
                if(arr[i + 1] == '0')dp[i] = dp[i + 2];
                else dp[i] = (dp[i + 1] + dp[i + 2]) % MOD;
            }
            else if(arr[i] == '1'){
                dp[i] = (dp[i + 1] + dp[i + 2]) % MOD;
            }
            else {
                dp[i] = dp[i + 1];
            }
        }
        System.out.println(dp[0]);
    }
}