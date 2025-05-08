import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 실버부수기

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1001);
        dp[0] = 0;
        int idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= idx; j++) {
                if(arr[i] < dp[j] && arr[i] > dp[j - 1]) {
                    if(j == idx)idx++;
                    dp[j] = arr[i];
                    break;
                }
            }
        }
        System.out.println(idx - 1);
    }
}
