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
    static int[] visited, from;
    static Deque<Node> queue = new ArrayDeque<>();
    static Deque<Integer> stack = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    static void check(){
        int p = K;
        stack.push(K);
        while (p != N){
            stack.push(from[p]);
//            System.out.println(from[p] + " : " + p);
            p = from[p];
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(' ');
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100_003];
        from = new int[100_003];
        from[N] = N;
        Arrays.fill(visited, 100_003);
        visited[N] = 1;

        queue.add(new Node(N, 0));
        if(N == K){
            System.out.println(0);
            System.out.println(N);
            return ;
        }
        if(N > K){
            sb.append(N - K).append('\n');
            for (int i = N; i >= K; i--) {
                sb.append(i).append(' ');
            }
            System.out.println(sb);
            return ;
        }
        while (!queue.isEmpty()) {
            Node n = queue.pollFirst();
            int next = n. no * 2;
            if (next <= K + 2) {
                if(next == K){
                    from[next] = n.no;
                    sb.append(n.cost + 1).append('\n');
                    check();
                    System.out.println(sb);
                    return ;
                }
                if(n.cost + 1 < visited[next]) {
                    visited[next] = n.cost + 1;
                    from[next] = n.no;
                    queue.offer(new Node(next, n.cost + 1));
                }
            }
            next = n.no - 1;
            if (next >= 0) {
                if(next == K){
                    from[next] = n.no;
                    sb.append(n.cost + 1).append('\n');
                    check();
                    System.out.println(sb);
                    return ;
                }
                if(n.cost + 1 < visited[next]) {
                    visited[next] = n.cost + 1;
                    from[next] = n.no;
                    queue.offer(new Node(next, n.cost + 1));
                }
            }
            next = n.no + 1;
            if (next <= 100000) {
                if(next == K){
                    from[next] = n.no;
                    sb.append(n.cost + 1).append('\n');
                    check();
                    System.out.println(sb);
                    return ;
                }
                if(n.cost + 1 < visited[next]) {
                    visited[next] = n.cost + 1;
                    from[next] = n.no;
                    queue.offer(new Node(next, n.cost + 1));
                }
            }

        }
    }
}
