import java.io.*;
import java.util.*;

class Node{
    int no;
    int cost;

    public Node(int no, int cost) {
        this.no = no;
        this.cost = cost;
    }
}
class Main {
    static int T, N, D, C;
    static int INF = 10_000_001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
            boolean[] visited = new boolean[N + 1];
            int[] costs = new int[N + 1];
            List<List<Node>> list = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                list.add(new ArrayList<>());
                costs[i] = INF;
            }
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int end = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list.get(start).add(new Node(end, cost));
            }
            costs[C] = 0;
            queue.add(new Node(C, 0));
            int ans1 = N;
            int ans2 = 0;
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if(visited[node.no]) continue;
                visited[node.no] = true;
                int size = list.get(node.no).size();
                for (int i = 0; i < size; i++) {
                    Node next = list.get(node.no).get(i);
                    if(costs[next.no] > node.cost + next.cost){
                        costs[next.no] = node.cost + next.cost;
                        queue.add(new Node(next.no, node.cost + next.cost));
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                if(costs[i] == INF) {
                    ans1--;
                    continue;
                }
                if(costs[i] > ans2) ans2 = costs[i];
            }
            sb.append(ans1).append(' ').append(ans2).append('\n');
        }

        System.out.println(sb);
    }
}