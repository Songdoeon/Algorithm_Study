import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer>[] list;
    static boolean[] visited;
    static int ans = 0;
    static Queue<Integer> queue = new ArrayDeque<>();
    static void search(int size){
        while (size-- > 0){
            int cur = queue.poll();

            for (int next : list[cur]) {
                if(visited[next])continue;
                visited[next] = true;
                queue.offer(next);
                ans++;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }

        visited[1] = true;

        queue.offer(1);

        search(1);
        search(queue.size());
        
        System.out.println(ans);

    }
}
