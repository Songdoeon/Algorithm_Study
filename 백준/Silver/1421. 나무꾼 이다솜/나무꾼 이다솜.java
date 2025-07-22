import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());

        int[] trees = new int[N];
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine().trim());
            if (trees[i] > maxLen) {
                maxLen = trees[i];
            }
        }

        long answer = 0;
        for (int l = 1; l <= maxLen; l++) {
            long totalProfit = 0;
            for (int len : trees) {
                int pieces = len / l;
                if (pieces == 0) continue;
                long revenue = pieces * (long)l * W;
                long cuts = (len % l == 0) ? (pieces - 1) : pieces;
                long cost = cuts * C;
                long profit = revenue - cost;
                if (profit > 0) {
                    totalProfit += profit;
                }
            }
            if (totalProfit > answer) {
                answer = totalProfit;
            }
        }

        System.out.println(answer);
    }
}
