import java.io.*;
import java.util.*;
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static final int INF = 1_000_001;
    static int[] arr, dp;
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[INF];
        int[] cnt = new int[INF];
        boolean[] visited = new boolean[INF];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            cnt[arr[i]]++;
            max = Math.max(max, arr[i]);
        }
        for (int i = 0; i < N; i++) {
            int num = arr[i];
            if(visited[num]) continue;
            visited[num] = true;
            int n = num;
            while (n <= max){
                dp[n] += cnt[num];
                n += num;
            }
        }
        for (int i = 0; i < N; i++) {
            sb.append(dp[arr[i]] - 1).append('\n');
        }
        System.out.println(sb);
    }
}