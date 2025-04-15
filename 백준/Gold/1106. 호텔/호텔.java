import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static int[][] info;
    static int[] dp;
    static final int INF = 200001;
    static int search(int customer){
        if(customer <= 0) return 0;
        if(dp[customer] != -1) return dp[customer];

        dp[customer] = INF;
        for(int i = 0; i < N; i++){
            dp[customer] = Math.min(dp[customer], search(customer - info[i][1]) + info[i][0]);
        }
        return dp[customer];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        info = new int[N][2];
        dp = new int[INF];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, -1);
        System.out.println(search(M));

    }
}
