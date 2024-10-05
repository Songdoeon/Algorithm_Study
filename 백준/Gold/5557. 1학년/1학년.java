import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[n][21];
        dp[0][numbers[0]] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 21; j++) {
                int plus = j + numbers[i];
                int minus = j - numbers[i];
                if(plus<=20) dp[i][plus] += dp[i-1][j];
                if(minus>=0) dp[i][minus] +=dp[i-1][j];
            }
        }
        System.out.println(dp[n-2][numbers[n-1]]);
    }
}