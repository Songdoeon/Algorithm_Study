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
    
    static int[] visited;
    static Deque<Node> queue = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        int N, K;
        N = in.nextInt();
        K = in.nextInt();
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
    static class Reader {
        final int SIZE = 1 << 13;
        byte[] buffer = new byte[SIZE];
        int index, size;

        int nextInt() throws Exception {
            int n = 0;
            byte c;
            while ((c = read()) <= 32);
            do n = (n << 3) + (n << 1) + (c & 15);
            while (isNumber(c = read()));
            return n;
        }

        boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }

        byte read() throws Exception {
            if (index == size) {
                size = System.in.read(buffer, index = 0, SIZE);
                if (size < 0)
                    buffer[0] = -1;
            }
            return buffer[index++];
        }
    }
}
