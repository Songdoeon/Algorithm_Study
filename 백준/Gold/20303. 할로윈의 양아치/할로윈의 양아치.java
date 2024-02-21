import java.io.*;
import java.util.*;

class Rel{
    int friendNum;
    long candyNum;

    public Rel(int friendNum, long candyNum) {
        this.friendNum = friendNum;
        this.candyNum = candyNum;
    }
}
public class Main {
    static int N, M, K;
    static int[] candies;
    static boolean[] visited;
    static long[][] dp;
    static List<Rel> candyList = new ArrayList<>();

    static long sum;
    static int friends;
    static ArrayList<Integer>[] graph;

    static void search(int idx){
        sum += candies[idx];
        friends++;
        for(int n : graph[idx]){
            if(visited[n]) continue;
            visited[n] = true;
            search(n);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candies = new int[N + 1];

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
            candies[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        for(int i = 1; i <= N; i++){
            if(visited[i]) continue;
            sum = 0;
            friends = 0;
            visited[i] = true;
            search(i);
            candyList.add(new Rel(friends, sum));
        }

        int size = candyList.size();
        dp = new long[size + 1][K + 1];


        for(int i = 1; i <= size; i++){
            Rel rel = candyList.get(i - 1);
            for (int j = 1; j <= K; j++) {
                dp[i][j] = (j - rel.friendNum) > 0 ? Math.max(dp[i - 1][j], rel.candyNum + dp[i - 1][j - rel.friendNum]) : dp[i - 1][j];
            }
        }

        System.out.println(dp[size][K]);
    }
}