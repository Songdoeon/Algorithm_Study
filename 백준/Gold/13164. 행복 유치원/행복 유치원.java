import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, dp;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i - 1] = arr[i] - arr[i - 1];
        }

        Arrays.sort(dp);
        int len = N - M;
        int sum = 0;
        for (int i = 0; i <= len; i++) {
            sum += dp[i];
        }
        System.out.println(sum);
    }

}