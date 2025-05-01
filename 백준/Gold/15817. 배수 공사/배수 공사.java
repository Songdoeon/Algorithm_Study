import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 15817 : 11:20 시작

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] dp;
    static int ans = 0;
    static int search(int idx, int len){
        if(len == 0) return 1;
        if(idx == N) return 0;
        if(dp[idx][len] != -1) return dp[idx][len];

        int ret = 0;

        int amount = arr[idx][0];
        int count = arr[idx][1];

        for (int i = 0; i <= count; i++) {
            int next = len - amount * i;
            if(next < 0) break;
            ret += search(idx + 1, next);
        }
        return dp[idx][len] = ret;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        dp = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= N ; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(search(0, M));
    }
}

