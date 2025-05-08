import java.io.*;
import java.util.*;


// 11497

public class Main {
    static int T, N;
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder   sb = new StringBuilder();
        T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if (N < 2) {
                sb.append(0).append('\n');
                continue;
            }

            Arrays.sort(arr);

            int ans = Math.max(arr[1] - arr[0], arr[N - 1] - arr[N - 2]);
            for (int i = 0; i + 2 < N; i++) {
                ans = Math.max(ans, arr[i + 2] - arr[i]);
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
