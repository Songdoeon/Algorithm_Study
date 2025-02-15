import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Node{
    double x, y;

    public Node(int x, int y) {
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

class Edge{
    int x, y;
    double c;
    public Edge(int x, int y, double c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }
}
class Main {
    static int N, M;
    static int[] parents;
    static Node[] nodes;
    static int find(int n){
        if(n == parents[n]) return n;
        return parents[n] = find(parents[n]);
    }
    static boolean union(int n, int m){
        int p1 = find(n);
        int p2 = find(m);
        if(p1 == p2) return false;
        if(p1 > p2) parents[p1] = p2;
        else parents[p2] = p1;
        return true;
    }

    static double getDis(int x, int y){
        return Math.sqrt(Math.pow(nodes[x].x - nodes[y].x, 2) +  Math.pow(nodes[x].y - nodes[y].y, 2));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> o.c));
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                queue.add(new Edge(i, j, getDis(i, j)));
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        double ans = 0;
        int edge = 0;
        while (!queue.isEmpty() && edge < N - 1) {
            Edge e = queue.poll();
            int x = e.x;
            int y = e.y;
            if(union(x, y)){
                ans += e.c;
                edge++;
            }
        }
        System.out.printf("%.2f", ans);
    }
}