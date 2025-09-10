import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        int idx = 1;

        for (int i = 2; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur != prev) {
                for (int k = idx; k <= i - 1; k++) arr[k] = i;
                idx = i;
                prev = cur;
            }
        }

        for (int k = idx; k <= N; k++) arr[k] = -1;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) sb.append(arr[i]).append(' ');

        System.out.print(sb);
    }
}
