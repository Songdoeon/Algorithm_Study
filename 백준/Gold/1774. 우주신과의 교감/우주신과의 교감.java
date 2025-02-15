import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    double x, y;

    public Node(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Edge {
    int start, end;
    double cost;

    public Edge(int start, int end, double cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}

class Main {
    static int N, M;
    static int[] parents;
    static Node[] nodes;

    static int find(int n) {
        if (n == parents[n]) return n;
        return parents[n] = find(parents[n]);
    }

    static boolean union(int n, int m) {
        int p1 = find(n);
        int p2 = find(m);
        if (p1 == p2) return false;
        if (p1 > p2) parents[p1] = p2;
        else parents[p2] = p1;
        return true;
    }

    static double getDistance(int x, int y) {
        return Math.sqrt(Math.pow(nodes[x].x - nodes[y].x, 2) + Math.pow(nodes[x].y - nodes[y].y, 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        Queue<Edge> edgeQueue = new PriorityQueue<>(Comparator.comparingDouble(o -> o.cost));
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                edgeQueue.add(new Edge(i, j, getDistance(i, j)));
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }

        double totalCost = 0;
        int edgesUsed = 0;

        while (!edgeQueue.isEmpty() && edgesUsed < N - 1) {
            Edge edge = edgeQueue.poll();
            int x = edge.start;
            int y = edge.end;
            if (union(x, y)) {
                totalCost += edge.cost;
                edgesUsed++;
            }
        }

        System.out.printf("%.2f\n", totalCost);
    }
}
