import java.io.*;
import java.util.*;

class Loaf{
    int weight, cost;

    public Loaf(int weight, int cost) {
        this.weight = weight;
        this.cost = cost;
    }
}
public class Main {
    static int N, M;
    static Loaf[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new Loaf[N];
        int[][] dp = new int[N + 1][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Loaf(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr, (o1, o2) -> o1.cost == o2.cost ? o2.weight - o1.weight : o1.cost - o2.cost);
        int cur = 0;
        for (int i = 1; i <= N; i++) {
            Loaf loaf = arr[i - 1];
            dp[i][0] = dp[i - 1][0] + loaf.weight;
            if(loaf.cost != cur){
                cur = loaf.cost;
                dp[i][1] = loaf.cost;
            }
            else {
                dp[i][1] = dp[i - 1][1] + loaf.cost;
            }

        }
        long ans = Long.MAX_VALUE;
  
        for (int i = 1; i <= N; i++) {
            if(dp[i][0] >= M) {
                ans = Math.min(ans, dp[i][1]);
            }
        }
        System.out.println(ans > Integer.MAX_VALUE ? -1 : ans);
    }
}