import java.io.*;
import java.util.*;

// 33754

public class Main {
    static int N, M;
    static List<Integer>[] graph, reverseGraph;
    static int[] count;

    static int search(int v){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        int ret = 0;
        boolean[] visited = new boolean[N + 1];
        while(!queue.isEmpty()){
            int u = queue.poll();
            visited[u] = true;
            for (int n : graph[u]) {
                if(visited[n]) continue;
                visited[n] = true;
                ret++;
                queue.add(n);
            }
        }
        if(ret >= (N + 1) / 2) return 1;
        queue.add(v);
        ret = 0;
        visited = new boolean[N + 1];
        while(!queue.isEmpty()){
            int u = queue.poll();
            visited[u] = true;

            for (int n : reverseGraph[u]) {
                if(visited[n]) continue;
                visited[n] = true;
                ret++;
                queue.add(n);
            }

        }
        if(ret >= (N + 1) / 2) return 1;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        reverseGraph = new List[N + 1];
        count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            reverseGraph[b].add(a);
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += search(i);
        }
        System.out.println(ans);
    }
}
