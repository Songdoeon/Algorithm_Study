import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        visited = new boolean[N + 1];
    }

    static void pro() {
        dfs(V);
        sb.append("\n");
        // visited 초기화
        reset_visited();
        bfs();

        System.out.println(sb);
    }

    static void reset_visited() {
        Arrays.fill(visited, false);
    }

    static void dfs(int start) {
        sb.append(start).append(" ");
        visited[start] = true;
        for(int x : graph[start]) {
            if(!visited[x]) {
                dfs(x);
            }
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        visited[V] = true;
        sb.append(V).append(" ");

        while(!q.isEmpty()) {
            int x = q.poll();

            for(int nx : graph[x]) {
                if(!visited[nx]) {
                    visited[nx] = true;
                    q.add(nx);
                    sb.append(nx).append(" ");
                }
            }
        }
    }
}