import java.io.*;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long result = 1;

        if (M <= N) {
            System.out.println(0);
            return;
        }
        for (long i = N; i > 0; i--) {
            result *= i;
            result %= M;

            if (result == 0) {
                break;
            }
        }
        System.out.println(result);
    }
}