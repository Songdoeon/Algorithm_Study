import java.io.*;
import java.util.*;

class Main{
    static int N, M;
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        int ans = Integer.MAX_VALUE;
        int idx = 0;
        boolean[] visited;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
            visited = new boolean[N + 1];
            visited[i] = true;
            int sum = 0;
            int total = 1;
            while (!queue.isEmpty()){
                int s = queue.size();{
                    for (int j = 0; j < s; j++) {
                        int p = queue.poll();
                        int size = graph[p].size();
                        for (int k = 0; k < size; k++) {
                            int next = graph[p].get(k);
                            if(visited[next])continue;
                            visited[next] = true;
                            sum += total;
                            queue.offer(next);
                        }
                    }
                    total++;
                }
            }
            if(ans > sum) {
                ans = sum;
                idx = i;
            }
        }
        System.out.println(idx);
    }
}