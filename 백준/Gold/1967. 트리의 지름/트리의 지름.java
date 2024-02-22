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
    static int N;

    static List<Node>[] list;
    static boolean[] visited;
    static int max = 0;
    static Node endNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Queue<Node> queue = new ArrayDeque<>();
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        if (N == 1) {
            System.out.println(0);
            return ;
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[n1].add(new Node(n2, weight));
            list[n2].add(new Node(n1, weight));
        }
        int size = 0;
        queue.add(new Node(1, 0));
        visited[1] = true;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(node.weight > max){
                endNode = node;
                max = node.weight;
            }
            size = list[node.no].size();

            for(int i = 0; i < size; i++){
                int nextNode = list[node.no].get(i).no;
                int nextWeight = list[node.no].get(i).weight;
                if(visited[nextNode]) continue;
                visited[nextNode] = true;
                queue.add(new Node(nextNode, node.weight + nextWeight));
            }
        }
        Arrays.fill(visited, false);
        queue.add(new Node(endNode.no, 0));
        visited[endNode.no] = true;

        while (!queue.isEmpty()){
            Node node = queue.poll();
            max = Math.max(max, node.weight);
            size = list[node.no].size();

            for(int i = 0; i < size; i++){
                int nextNode = list[node.no].get(i).no;
                int nextWeight = list[node.no].get(i).weight;
                if(visited[nextNode]) continue;
                visited[nextNode] = true;
                queue.add(new Node(nextNode, node.weight + nextWeight));
            }
        }

        System.out.println(max);
    }
}