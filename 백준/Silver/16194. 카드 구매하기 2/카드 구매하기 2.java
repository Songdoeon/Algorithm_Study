import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 16194

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;

    static int search(int card){
        if(card == 0) return 0;
        if(dp[card] != -1) return dp[card];

        int ret = 1_000_000_001;
        for(int i = 1; i <= card; i++){
            if(card - i < 0) continue;
            ret = Math.min(ret, arr[i] + search(card - i));
        }

        return dp[card] = ret;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, -1);
        System.out.println(search(N));
    }
}
