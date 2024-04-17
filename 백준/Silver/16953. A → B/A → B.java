import java.util.*;
import java.io.*;
class Node{
    int no;
    long cost;

    public Node(int no, long cost) {
        this.no = no;
        this.cost = cost;

    }
}
class Main {
    static int N, M;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        BitSet[] set = new BitSet[10];
        for (int i = 0; i < 10; i++) {
            set[i] = new BitSet();
        }

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(N, 1));
        long result = -1;
        while (!q.isEmpty()){
            Node n =  q.poll();
            if(n.no == M) {
                result = n.cost;
                break;
            }
            long next = n.no * 2;
            int hash = (int) next / 100_000_000;
            int key = (int )next - (hash * 100_000_000);
//            System.out.println(hash + " : " + key);
            if(next <= M && !set[hash].get(key)){
                set[hash].get(key);
                q.offer(new Node((int)next, n.cost + 1));
            }
            if(n.no > 100_000_000) continue;
            next = n.no * 10 + 1;
            if(next > M) continue;
//            System.out.println(n.no);
//            System.out.println(next);
            hash =(int) (next / 100_000_000);
            key =(int) (next - (hash * 100_000_000));
//            System.out.println(hash + " : " + key);
            if(!set[hash].get(key)){
                set[hash].get(key);
                q.offer(new Node((int)next, n.cost + 1));
            }
        }
        System.out.println(result);
    }
}