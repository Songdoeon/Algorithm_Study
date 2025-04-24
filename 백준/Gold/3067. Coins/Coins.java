import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T, N, target;
    static int[] arr;
    static int[][] dp;
    static int search(int idx, int weight){
//        System.out.println(idx + " : " + weight);
        if(idx >= N) return 0;
        if(weight > target) return 0;
        if(weight == target) return 1;
        
        if(dp[idx][weight] != -1) return dp[idx][weight];
        dp[idx][weight] = 0;
        for (int i = idx; i < N; i++) {
            dp[idx][weight] += search(i, weight + arr[i]);
        }
        return dp[idx][weight];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (T-- > 0){
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            target = Integer.parseInt(br.readLine());
            dp = new int[N][target + 1];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], -1);
            }
            sb.append(search(0, 0)).append('\n');
        }
        System.out.println(sb);
    }
}
