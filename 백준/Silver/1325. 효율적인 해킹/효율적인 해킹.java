import java.util.*;
import java.io.*;


public class Main {
    static int N, M;
    static int[] costs;
    static List<Integer>[] list;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        list = new List[N + 1];
        costs = new int[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            list[n2].add(n1);
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
            visited = new boolean[N + 1];
            visited[i] = true;
            int cnt = 1;
            while (!queue.isEmpty()){
                int p = queue.poll();

                for (int next : list[p]){
                    if(visited[next]) continue;
                    visited[next] = true;
                    queue.offer(next);
                    cnt++;
                }
            }
            costs[i] = cnt;
            max = Math.max(max, cnt);
        }

        for (int i = 1; i <= N; i++) {
            if(costs[i] == max){
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }
}
