import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N == 0) {
            if(M == 0) System.out.println(0);
            else System.out.println(-1);
            return ;
        }
        
        int[] P = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }


        final int OFFSET = 1000;
        final int MAXV   = 2000;

        int[] dist = new int[MAXV + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Deque<Integer> q = new ArrayDeque<>();

        dist[OFFSET] = 0;
        q.add(OFFSET);

        while (!q.isEmpty()) {
            int u = q.poll();
            int d = dist[u];
            if (u == M + OFFSET) break;

            for (int coin : P) {
                int v = u + coin;
                if (v < 0 || v > MAXV) continue;

                if (dist[v] > d + 1) {
                    dist[v] = d + 1;
                    q.add(v);
                }
            }
        }

        int ans = dist[M + OFFSET];
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
