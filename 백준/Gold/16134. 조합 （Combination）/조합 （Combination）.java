import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static final int MOD = 1_234_567_891;
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
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= N; i++) {
            arr[i] = (arr[i - 1] * i) % MOD;
        }
        long ans = arr[N] * (calc(arr[K]) * calc(arr[N - K]) % MOD) % MOD;

        System.out.println(ans);
    }
}
