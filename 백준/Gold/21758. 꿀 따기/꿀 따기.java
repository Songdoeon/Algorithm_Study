import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }
        int result = 0;
        for (int i = 2;i < N; i++) {
            result = Math.max(sum[i] - sum[1] + sum[N] - sum[i] + arr[i] - arr[N],
                    Math.max(sum[N] - sum[0] - arr[N] + sum[i] - sum[0] - arr[i] - arr[i],
                    Math.max(result, sum[N] - sum[i] + sum[N] - sum[1] - arr[i])));
        }
        System.out.println(result);
    }
}
