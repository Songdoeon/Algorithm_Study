import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static final int MAX = 1_000_000;
    static int[] arr = new int[MAX + 1];

    static boolean check(int N) {
        int x = 8 * N + 1;
        int r = (int) Math.sqrt(x);
        return r * r == x;
    }

    public static void main(String[] args) throws IOException {
        for (int d = 1; d <= MAX; d += 2) {
            for (int m = d; m <= MAX; m += d) {
                arr[m]++;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            int ans = arr[N];
            if (check(N)) {
                ans--;  
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
