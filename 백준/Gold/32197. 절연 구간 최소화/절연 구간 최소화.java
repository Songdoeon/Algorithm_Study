import java.io.*;
import java.util.*;

class Edge {
    int to, mode;
    Edge(int t, int m) { this.to = t; this.mode = m; }
}

class Node {
    int v, mode, cost;
    Node(int v, int mode, int cost) {
        this.v = v; this.mode = mode; this.cost = cost;
    }
}

public class Main {
    static int N, M;
    static List<Edge>[] adj;
    static final int INF = Integer.MAX_VALUE / 3;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adj[u].add(new Edge(v, t));
            adj[v].add(new Edge(u, t));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // dist[node][mode] = 절연 최소 횟수로 node에 mode 방식으로 도달
        int[][] dist = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            dist[i][0] = INF;
            dist[i][1] = INF;
        }

        Deque<Node> dq = new ArrayDeque<>();
        // 시작은 방식 0,1 둘 다 가능하게 등록 (게시판 참고: 미리 어떤 방식이든 허용)
        dist[A][0] = 0;
        dist[A][1] = 0;
        dq.offer(new Node(A, 0, 0));
        dq.offer(new Node(A, 1, 0));

        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();
            int v = cur.v, pm = cur.mode, c = cur.cost;
            if (c > dist[v][pm]) continue;

            for (Edge e : adj[v]) {
                int nv = e.to;
                int nm = e.mode;
                int extra = (pm == nm) ? 0 : 1;
                int nc = c + extra;

                if (nc < dist[nv][nm]) {
                    dist[nv][nm] = nc;
                    if (extra == 0) {
                        dq.offerFirst(new Node(nv, nm, nc));
                    } else {
                        dq.offerLast(new Node(nv, nm, nc));
                    }
                }
            }
        }

        int ans = Math.min(dist[B][0], dist[B][1]);
        if (ans >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
