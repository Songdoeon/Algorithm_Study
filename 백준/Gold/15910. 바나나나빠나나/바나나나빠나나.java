import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int M = S.length();
        final int INF = 1_000_000_000;

        int[] prev = new int[7];
        int[] curr = new int[7];
        Arrays.fill(prev, INF);
        prev[0] = 0;  // S0에서 시작

        for (int i = 1; i <= M; i++) {
            Arrays.fill(curr, INF);
            char c = S.charAt(i - 1);
            int costB = (c == 'B' ? 0 : 1);
            int costA = (c == 'A' ? 0 : 1);
            int costN = (c == 'N' ? 0 : 1);

            curr[1] = Math.min(Math.min(prev[0], prev[1]), prev[6]) + costB;
            curr[2] = prev[1] + costA;
            curr[3] = prev[2] + costN;
            curr[4] = prev[3] + costA;
            curr[5] = Math.min(prev[4], prev[6]) + costN;
            curr[6] = prev[5] + costA;

            int[] tmp = prev;
            prev = curr; 
            curr = tmp;
        }

        System.out.println(prev[6]);
    }
}
