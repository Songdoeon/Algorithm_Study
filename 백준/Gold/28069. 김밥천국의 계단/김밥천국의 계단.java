import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] dp;
    static boolean found = false;

    static void search(int idx, int k) {
        if (found) return;          
        if (k > K) return;        
        if (idx == N) {         
            found = true;
            return;
        }

        if (dp[idx] <= k) return;
        dp[idx] = k;

        search(idx + 1, k + 1);

        if (idx > 0) {
            int jump = idx + (idx / 2);
            if (jump <= N) {
                search(jump, k + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N <= K) {
            System.out.println("minigimbob");
            return;
        }

        dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        search(0, 0);
        System.out.println(found ? "minigimbob" : "water");
    }
}
