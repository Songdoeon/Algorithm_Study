
import java.util.*;
import java.io.*;

class Node{
    int no, cost;

    public Node(int no, int cost) {
        this.no = no;
        this.cost = cost;
    }
}
class Main {
    static int N, M;
    static List<Node>[] list;
    static int[][] map;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Node> queue = new PriorityQueue<>( Comparator.comparingInt(o -> o.cost));
        Queue<Integer> q = new ArrayDeque<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[n1].add(new Node(n2, cost));
            list[n2].add(new Node(n1, cost));
        }

        while (M-- > 0){
            boolean[] visited = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int cnt = 0;
            visited[start] = true;
            int size = list[start].size();
            for (int i = 0; i < size; i++) {
                Node n = list[start].get(i);
                if(n.cost >= K) {
                    q.offer(n.no);
                    visited[n.no] = true;
                    cnt++;
                }
            }
            while (!q.isEmpty()){
                int p = q.poll();
                size = list[p].size();
                for (int i = 0; i < size; i++) {
                    Node n = list[p].get(i);
                    if(n.cost < K) continue;
                    if(visited[n.no])continue;
                    visited[n.no] = true;
                    q.offer(n.no);
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}