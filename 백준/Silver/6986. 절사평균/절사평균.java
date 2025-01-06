import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static double[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new double[N];
        double ans1 = 0.0;
        double ans2 = 0.0;
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        Arrays.sort(arr);
        int endIdx = N - K;
        for (int i = 0; i < N; i++) {
            if(i < K) {
                ans2 += arr[K];
            }
            else if (endIdx <= i) {
                ans2 += arr[endIdx - 1];
            }
            else {
                ans1 += arr[i];
                ans2 += arr[i];
            }
        }
        System.out.printf("%.2f\n%.2f", (ans1 / (N - (K * 2))), (ans2 / N));
    }
}