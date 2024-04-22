import java.io.*;
import java.util.*;

class Pos{
    int no, x, y, z;

    public Pos(int no, int x, int y, int z) {
        this.no = no;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
class Edge{
    int n1, n2, cost;

    public Edge(int n1, int n2, int cost) {
        this.n1 = n1;
        this.n2 = n2;
        this.cost = cost;
    }
}
class Main{
    static int N;
    static Pos[] arr;
    static int[] parent;
    static int getDis(Pos p1, Pos p2){
        return Math.min(Math.abs(p1.x - p2.x), Math.min(Math.abs(p1.y - p2.y), Math.abs(p1.z - p2.z)));
    }
    static int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
    static boolean union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2) return false;
        if(p1 < p2) parent[p2] = p1;
        else parent[p1] = p2;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        N = Integer.parseInt(st.nextToken());
        arr = new Pos[N];
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            arr[i] = new Pos(i, x, y, z);
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o.x));

        for (int i = 0; i < N - 1; i++) {
            queue.offer(new Edge(arr[i].no, arr[i + 1].no, getDis(arr[i], arr[i + 1])));
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o.y));

        for (int i = 0; i < N - 1; i++) {
            queue.offer(new Edge(arr[i].no, arr[i + 1].no, getDis(arr[i], arr[i + 1])));
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o.z));

        for (int i = 0; i < N - 1; i++) {
            queue.offer(new Edge(arr[i].no, arr[i + 1].no, getDis(arr[i], arr[i + 1])));
        }
        int n = 0;
        int cost = 0;
        while (n != N - 1){
            Edge e = queue.poll();
            int n1 = e.n1;
            int n2 = e.n2;
            if(union(n1, n2)){
                n++;
                cost += e.cost;
            }
        }
        System.out.println(cost);
    }
}