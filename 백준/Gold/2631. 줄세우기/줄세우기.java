import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[N];
        int idx = 0;
        Arrays.fill(dp, N + 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= idx; j++) {
                if(arr[i] < dp[j]) {
                    if(j == idx)idx++;
                    dp[j] = arr[i];
                    break;
                }
            }
        }
        System.out.println(N - idx);
    }
}
