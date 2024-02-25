import java.io.*;
import java.util.*;
class Edge{
    int n1;
    int n2;
    int cost;

    public Edge(int n1, int n2, int cost) {
        this.n1 = n1;
        this.n2 = n2;
        this.cost = cost;
    }
}
public class Main {
    static int[] parents;
    static int find(int n){
        if(parents[n] == n) return n;
        return parents[n] = find(parents[n]);
    }
    static boolean union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2) return true;

        if(p1 > p2) parents[p2] = p1;
        else parents[p1] = p2;
        return false;
    }
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        int cost = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            queue.offer(new Edge(n1, n2, w));
        }

        int e = 0;
        while (e < N - 2){
            Edge edge = queue.poll();
            if(!union(edge.n1, edge.n2)){
                e++;
                cost += edge.cost;
            }
        }
        System.out.println(cost);
    }
}
