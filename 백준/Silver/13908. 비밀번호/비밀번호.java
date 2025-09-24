import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(M > 0) br.readLine();

        M = 1 << M;
        int ans = 0;

        for (int mask = 0; mask < M; mask++) {
            int k = Integer.bitCount(mask);
            int term = (int)Math.pow(10 - k, N);
            ans += k % 2 == 0 ? term : -term;
        }

        System.out.println(ans);
    }
}
