import java.io.*;
import java.util.*;
class Main {
    static int N, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        for (int i = N; i < N + K; i++) {
            arr[i] = arr[i - N];
        }
        int ans = 0;
        for (int i = 0; i < K; i++) {
            ans += arr[i];
        }
        int s = 0;
        int end = K;
        int sum = ans;
        while (end < N + K){
            sum = sum - arr[s++] + arr[end++];
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}
