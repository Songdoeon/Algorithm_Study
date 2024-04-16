import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
    static int[] dist, from;
    static boolean[] visited;
    // 1_000 * 100_000
    static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new List[N + 1];
        dist = new int[N + 1];
        from = new int[N + 1];
        visited = new boolean[N + 1];
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        queue.offer(new Node(start, 0));
        Arrays.fill(dist, INF);
        dist[start] = 0;
        while (!queue.isEmpty()){
            Node n = queue.poll();
//            System.out.println(n.no + " : " + n.cost);
            if(n.no == end){
//                System.out.println("-----");
                int cost = n.cost;
                int cnt = 1;
                int no = n.no;
                sb.append(start).append(' ');
                Deque<Integer> stack = new ArrayDeque<>();
                while (no != start){
                    stack.push(no);
                    no = from[no];
                    cnt++;
                }
                while (!stack.isEmpty()){
                    sb.append(stack.pop()).append(' ');
                }

                System.out.println(cost + "\n" + cnt + "\n" +sb);
                return ;
            }
            if(visited[n.no])continue;
            visited[n.no] = true;

            int size = list[n.no].size();
            for (int i = 0; i < size; i++) {
                Node next = list[n.no].get(i);
                if(dist[next.no] > next.cost + n.cost){
                    dist[next.no] = next.cost + n.cost;
                    from[next.no] = n.no;
                    queue.offer(new Node(next.no, next.cost + n.cost));
                }
            }
        }

        System.out.println();
    }
}