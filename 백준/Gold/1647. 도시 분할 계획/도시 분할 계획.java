import java.io.*;
import java.util.*;
class Node{
    int no, weight;

    public Node(int no, int weight) {
        this.no = no;
        this.weight = weight;
    }
}
public class Main {
    static int N, M;
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        Queue<Integer> costQueue = new PriorityQueue<>(Collections.reverseOrder());
        int cost = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[n1].add(new Node(n2, w));
            list[n2].add(new Node(n1, w));
        }
        queue.offer(new Node(1, 0));

        int v = 0;
        while (!queue.isEmpty()){
            Node now = queue.poll();
            if(visited[now.no])continue;
            visited[now.no] = true;
            v++;
            cost += now.weight;
            costQueue.offer(now.weight);
            if(v == N) break;

            int size = list[now.no].size();
            for (int i = 0; i < size; i++) {
                Node next = list[now.no].get(i);
                if(visited[next.no])continue;
                queue.add(new Node(next.no, next.weight));
            }
        }
        System.out.println(cost - costQueue.poll());
    }
}
