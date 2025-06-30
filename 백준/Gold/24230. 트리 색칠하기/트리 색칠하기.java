import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 24230

public class Main {
    static int N;
    static List<Integer>[] nodes;
    static int[] target;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        target = new int[N + 1];
        nodes = new List[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
            target[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }

        int ans = 0;
        if(target[1] != 0) ans++;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for(Integer next : nodes[cur]) {
                if(visited[next]) continue;
                visited[next] = true;
                queue.offer(next);
                if(target[next] != target[cur]) ans++;
            }
        }

        System.out.println(ans);
    }
}
