import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[N+1];
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] next = new int[N+1], prev = new int[N+1];
        for (int i = 1; i <= N; i++) {
            next[i] = (i == N ? 1 : i+1);
            prev[i] = (i == 1 ? N : i-1);
        }

        StringBuilder sb = new StringBuilder();
        int cur = 1;

        for (int step = 0; step < N; step++) {
            sb.append(cur).append(' ');

            int move = a[cur];

            next[ prev[cur] ] = next[cur];
            prev[ next[cur] ] = prev[cur];

            if (step == N-1) break;  // 마지막 풍선이므로 더 이동할 필요 없음

            if (move > 0) {
                cur = next[cur];
                for (int k = 1; k < move; k++) {
                    cur = next[cur];
                }
            }

            else {
                cur = prev[cur];
                for (int k = 1; k < -move; k++) {
                    cur = prev[cur];
                }
            }
        }

        System.out.println(sb);
    }
}
