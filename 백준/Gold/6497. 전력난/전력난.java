import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int n, c;

    public Node(int n, int c) {
        this.n = n;
        this.c = c;
    }
}
public class Main {
    static int N, M;
    static boolean[] visited;
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 || M == 0) {
                System.out.println(sb);
                break;
            }
            list = new List[N];
            visited = new boolean[N];

            for (int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
            }
            int max = 0;
            int s = 0;
            int e = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());

                int c = Integer.parseInt(st.nextToken());
                list[s].add(new Node(e, c));
                list[e].add(new Node(s, c));
                max += c;
            }

            int ans = 0;

            Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.c - o2.c);
            queue.offer(new Node(0, 0));

            while (!queue.isEmpty()){
                Node n = queue.poll();
                if(visited[n.n])continue;
                visited[n.n] = true;
                ans += n.c;
                int size = list[n.n].size();
                for (int i = 0; i < size; i++) {
                    Node next = list[n.n].get(i);
                    if(visited[next.n])continue;
                    queue.offer(new Node(next.n, next.c));
                }
            }
            sb.append(max - ans).append('\n');
        }
    }
}
