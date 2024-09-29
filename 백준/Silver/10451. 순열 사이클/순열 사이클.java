import java.util.*;
import java.io.*;

public class Main {
    static int T, N;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            int ans = 0;
            arr = new int[N + 1];
            visited = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= N; i++) {
                if(visited[arr[i]]) continue;
                visited[arr[i]] = true;
                int e = arr[i];
                ans++;
                while (!visited[arr[e]]){
                    visited[arr[e]] = true;
                    e = arr[e];
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
