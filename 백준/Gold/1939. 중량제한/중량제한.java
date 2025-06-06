import java.io.*;
import java.util.*;

// 1939

class Node{
    int n, c;

    public Node(int n, int c) {
        this.n = n;
        this.c = c;
    }
}
public class Main {
    static int N, M;
    static List<Node>[] list;
    static int[] costs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N + 1];
        costs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new PriorityQueue<>((a, b) -> b.c - a.c);

        queue.offer(new Node(s, Integer.MAX_VALUE));
        boolean[] visited = new boolean[N + 1];

        int ans = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int node = cur.n;
            int cost = cur.c;
            if(node == e){
                ans = Math.max(ans, cost);
                break;
            }
            for (Node next : list[node]) {
                int c = Math.min(next.c, cost);
                if(costs[next.n] < c){
                    costs[next.n] = c;
                    queue.offer(new Node(next.n, c));
                }
            }
        }
        System.out.println(ans);
    }
}
