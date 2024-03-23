import java.io.*;
import java.util.*;

class Node{
    int next, potion;
    double cost;

    public Node(int next, int potion, double cost) {
        this.next = next;
        this.potion = potion;
        this.cost = cost;
    }
}
public class Main {
    static int N, M;
    static List<List<Node>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> o.cost));
        double[][] costs = new double[M + 1][N];
        boolean[][] visited = new boolean[M + 1][N];
        for (int i = 0; i <= M; i++) {
            Arrays.fill(costs[i], 10);
            costs[i][0] = 0;
        }
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            char[] info = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if(i == j) continue;
                graph.get(i).add(new Node(j, 0,info[j]-'0'));
            }
        }

        queue.add(new Node(0, 0,0));
        for (int i = 1; i <= M; i++) {
            visited[i][0] = true;
        }
        while (!queue.isEmpty()){
            Node n = queue.poll();
            if(n.next == 1) {
                System.out.println(costs[n.potion][1]);
                break;
            }
            if(visited[n.potion][n.next]) continue;
            visited[n.potion][n.next] = true;
            for(Node nextNode : graph.get(n.next)) {
                if(costs[n.potion][nextNode.next] > costs[n.potion][n.next] + nextNode.cost) {
                    costs[n.potion][nextNode.next] = costs[n.potion][n.next] + nextNode.cost;
                    queue.add(new Node(nextNode.next, n.potion, costs[n.potion][nextNode.next]));
                }
                int nextPotion = n.potion + 1;
                if(n.potion < M && costs[nextPotion][nextNode.next] > costs[n.potion][n.next] + (nextNode.cost / 2)) {
                    costs[nextPotion][nextNode.next] = costs[n.potion][n.next] + (nextNode.cost / 2);
                    queue.add(new Node(nextNode.next, nextPotion, costs[nextPotion][nextNode.next]));
                }
            }
        }
    }
}
