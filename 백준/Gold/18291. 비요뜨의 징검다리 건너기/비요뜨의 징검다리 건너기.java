import java.io.BufferedReader;
import java.io.InputStreamReader;

// 18291

public class Main {
    static int T, N;
    static final int MOD = 1000000007;
    static long search(){
        long a = 2;
        long e = Math.max(0, N - 2);
        long res = 1L;

        while (e > 0) {
            if ((e & 1L) == 1L) res = (res * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return res;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            N = Integer.parseInt(br.readLine());
            sb.append(search()).append('\n');
        }
        System.out.println(sb);
    }
}
