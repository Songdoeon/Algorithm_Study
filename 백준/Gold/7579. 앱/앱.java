import java.io.*;
import java.util.*;
class App{
    int memory, cost;

    public App(String memory, String cost) {
        this.memory = Integer.parseInt(memory);
        this.cost = Integer.parseInt(cost);
    }
}
public class Main {
    static int N, M;
    static int[][] map = new int[9][9];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        App[] apps = new App[N];
        int[][] dp = new int[N][100001];
        st = new StringTokenizer(br.readLine());
        StringTokenizer sts = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            apps[i] = new App(st.nextToken(), sts.nextToken());
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < N; i++){
            int cost = apps[i].cost;
            int memory = apps[i].memory;
            for(int j = 0; j <= 10000; j++){
                if(i == 0) {
                    if (j >= cost) dp[i][j] = memory;
                }
                else {
                    if (j >= cost) dp[i][j] = Math.max(dp[i - 1][j - cost] + memory, dp[i - 1][j]);
                    else dp[i][j] = dp[i - 1][j];
                }
                if(dp[i][j] >= M) ans = Math.min(ans, j);
            }
        }
        System.out.println(ans);
    }
}