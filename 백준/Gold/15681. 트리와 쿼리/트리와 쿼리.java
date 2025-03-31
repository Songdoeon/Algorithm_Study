import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 11:51 시작
class Main{
    static int N, R, Q;
    static List<Integer>[] list;
    static int[] dp;
    static int search(int node){
        dp[node] = 1;
        for(int next : list[node]){
            if(dp[next] != 0) continue;
            dp[node] += search(next);
        }
        return dp[node];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        list = new List[N + 1];
        dp = new int[N + 1];

        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        search(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
}