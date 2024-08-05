import java.io.*;
import java.util.*;

class Main {
    static int N, M, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int ans = 0;
        while (N < M){
            N += K;
            ans++;
        }
        System.out.println(ans);
    }
}
