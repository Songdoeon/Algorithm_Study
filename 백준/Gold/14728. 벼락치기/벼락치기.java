import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static int[][] info;
    static int[][] dp;

    static int search(int idx, int time){
        if(time >= M || idx >= N) return 0;
        if(dp[idx][time] != -1) return dp[idx][time];

        if(info[idx][0] + time <= M) dp[idx][time] = Math.max(search(idx + 1, time),
                search(idx + 1, time + info[idx][0]) + info[idx][1]);
        else dp[idx][time] = search(idx + 1, time);
        return dp[idx][time];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        info = new int[N][2];
        dp = new int[N][M + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }
        System.out.println(search(0, 0));

    }
}
