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
    static boolean[] visited;
    static Deque<Node> queue = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        N = read();
        K = read();
        visited = new boolean[100_002];
        visited[N] = true;
        queue.add(new Node(N, 0));
        int answer =  0;

        while (!queue.isEmpty()) {
            Node n = queue.removeFirst();
            if(n.no == K) {
                answer = n.cost;
                break;
            }
            int next = n. no * 2;
            if (next <= K + 2 && !visited[next]) {
                visited[next] = true;
                queue.addFirst(new Node( next, n.cost));
            }
            next = n.no - 1;
            if (next >= 0 && !visited[next]) {
                visited[next] = true;
                queue.addLast(new Node( next, n.cost + 1));
            }
            next = n.no + 1;
            if (next <= 100000 && !visited[next]) {
                visited[next] = true;
                queue.addLast(new Node( next, n.cost + 1));
            }
        }
        System.out.println(answer);
    }
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
