import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, dp;

    static int search(int idx){
        if(idx >= N) return 0;
        if(dp[idx] != -1) return dp[idx];

        int ret = 0;
        int rest = N - idx;

        for(int i = 1; i <= rest; i++) ret = Math.max(ret, search(idx + i) + arr[i]);

        return dp[idx] = ret;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.fill(dp, -1);
        
        System.out.println(search(0));

    }
}
