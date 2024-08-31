import java.util.*;
import java.io.*;

class Main {
    static int T, N, M, ans;
    static List<Integer>[] graph, reverseGraph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        graph = new List[N + 1];
        reverseGraph = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            reverseGraph[n2].add(n1);
        }
        ans = 0;
        for (int i = 1; i <= N; i++) {
            int cnt = 1;
            visited = new boolean[N + 1];
            queue.offer(i);
            while (!queue.isEmpty()){
                int p = queue.poll();
                for(int next : graph[p]){
                    if(visited[next])continue;
                    visited[next] = true;
                    cnt++;
                    queue.offer(next);
                }
            }
            queue.offer(i);
            while (!queue.isEmpty()){
                int p = queue.poll();
                for(int next : reverseGraph[p]){
                    if(visited[next])continue;
                    visited[next] = true;
                    cnt++;
                    queue.offer(next);
                }
            }
            sb.append(N - cnt).append('\n');
        }
        System.out.println(sb);
    }
}
