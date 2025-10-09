import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] costs;
    static List<Integer>[] arr;
    static int[][] dp;
    static boolean[] visited;

    static void search(int u) {
        visited[u] = true;
        dp[u][0] = 0;
        dp[u][1] = costs[u];
        for (int v : arr[u]) {
            if (visited[v]) continue;
            search(v);
            dp[u][1] += dp[v][0];
            dp[u][0] += Math.max(dp[v][0], dp[v][1]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        costs = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }
        arr = new List[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        search(1);

        int answer = Math.max(dp[1][0], dp[1][1]);
        System.out.println(answer);
    }
}
