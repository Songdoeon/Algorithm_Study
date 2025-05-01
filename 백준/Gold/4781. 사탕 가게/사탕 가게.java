import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 4781 : 08:20 시작

public class Main {
    static int N, M;
    static int[] kcal, price;
    static int[] dp;
    static int parse(String s){
        String[] arr = s.split("\\.");
        return Integer.parseInt(arr[0]) * 100 + Integer.parseInt(arr[1]);
    }
    static int search(int money) {
        if (money == 0) return 0;
        if (dp[money] != -1) return dp[money];

        int best = 0;
        // 모든 사탕 종류를 시도
        for (int i = 0; i < N; i++) {
            if (price[i] <= money) {
                int v = search(money - price[i]) + kcal[i];
                if (v > best) best = v;
            }
        }
        return dp[money] = best;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = parse(st.nextToken());
            if(N == 0 && M == 0) {
                System.out.println(sb);
                break ;
            }
            kcal = new int[N];
            price = new int[N];
            dp = new int[M + 1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                kcal[i] = Integer.parseInt(st.nextToken());
                price[i] = parse(st.nextToken());
            }
            Arrays.fill(dp, -1);
            sb.append(search(M)).append('\n');
        }
    }
}

