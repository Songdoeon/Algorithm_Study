import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static final int MOD = 1_000_000_007;
    static long calc(long a){
        int k = MOD - 2;
        long ret = 1;
        while (k > 0){
            if(k % 2 == 1) ret = ret * a % MOD;
            a = (a * a) % MOD;
            k /= 2;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());

        long[] arr = new long[4_000_001];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < 4_000_001; i++) {
            arr[i] = (arr[i - 1] * i) % MOD;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            sb.append(arr[n] * (calc(arr[k]) * calc(arr[n - k]) % MOD) % MOD).append('\n');
        }
        System.out.println(sb);
    }
}
