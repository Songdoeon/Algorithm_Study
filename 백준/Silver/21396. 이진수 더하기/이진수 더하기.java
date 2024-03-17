import java.io.*;
import java.util.*;

public class Main {
    static int T, N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Map<Integer, Integer> map;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            long cnt = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            map = new HashMap<>(N);
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                cnt += map.getOrDefault(n, 0);
                map.put(M ^ n, map.getOrDefault(M ^ n, 0) + 1);
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}