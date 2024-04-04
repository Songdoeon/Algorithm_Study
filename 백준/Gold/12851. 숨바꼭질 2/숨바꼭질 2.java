import java.util.*;
import java.io.*;

class Node{
    int no, cost;

    public Node(int no, int cost) {
        this.no = no;
        this.cost = cost;
    }
}
public class Main {
    static int N, K;
    static int[] visited;
    static Deque<Node> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100_003];
        Arrays.fill(visited, 100_003);
        visited[K] = 0;
        boolean find = false;
        int cnt = 0;
        int time = Integer.MAX_VALUE;
        visited[N] = 1;
        queue.add(new Node(N, 0));
        if(K <= N) {
            System.out.println((N - K) + "\n" + 1);
            return ;
        }
        while (!queue.isEmpty()) {
            Node n = queue.pollFirst();

            if(n.cost >= time) break;

            int next = n. no * 2;
            if (next <= K + 2) {
                if(next == K){
                    if(!find) {
                        find = true;
                        time = n.cost + 1;
                    }
//                    System.out.println(n.no + " : " + n.cost);
                    cnt++;
                }
                else{
                    if(n.cost + 1 <= visited[next]) {
                        visited[next] = n.cost + 1;
                        queue.offer(new Node(next, n.cost + 1));
                    }
                }
            }
            next = n.no - 1;
            if (next >= 0) {
                if(next == K){
                    if(!find) {
                        find = true;
                        time = n.cost + 1;
                    }
//                    System.out.println(n.no + " : " + n.cost);
                    cnt++;
                }
                else{
                    if(n.cost + 1 <= visited[next]) {
                        visited[next] = n.cost + 1;
                        queue.offer(new Node(next, n.cost + 1));
                    }
                }
            }
            next = n.no + 1;
            if (next <= 100000) {
                if(next == K){
                    if(!find) {
                        find = true;
                        time = n.cost + 1;
                    }
//                    System.out.println(n.no + " : " + n.cost);
                    cnt++;
                }
                else{
                    if(n.cost + 1 <= visited[next]) {
                        visited[next] = n.cost + 1;
                        queue.offer(new Node(next, n.cost + 1));
                    }
                }

            }
        }
        System.out.println(time + "\n" + cnt);
    }
}
