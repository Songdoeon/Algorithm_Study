import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        visited[0] = true;
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(Integer.parseInt(br.readLine()));
        int ans = 1;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            int prev = n - arr[n];
            int next = n + arr[n];
            if(prev > 0 && !visited[prev]) {
                queue.add(prev);
                ans++;
                visited[prev] = true;
            }
            if(next <= N && !visited[next]) {
                queue.add(next);
                ans++;
                visited[next] = true;
            }
        }
        System.out.println(ans);
    }
}
