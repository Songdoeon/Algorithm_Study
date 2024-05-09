import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] map;
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[101];
        visited = new boolean[101];
        for (int i = 1; i < 101; i++) {
            map[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        queue.offer(1);
        visited[1] = true;
        int ans = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int n = queue.poll();
                if(n == 100) {
                    System.out.println(ans);
                    return ;
                }
                for (int j = 1; j <= 6; j++) {
                    if(n + j > 100)continue;
                    if(visited[map[n + j]])continue;
                    visited[map[n + j]] = true;
                    queue.offer(map[n + j]);
                }
            }
            ans++;
        }
    }
}