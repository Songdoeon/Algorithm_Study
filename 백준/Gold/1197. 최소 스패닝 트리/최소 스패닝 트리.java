import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    int n1;
    int n2;
    int weight;

    public Edge(int n1, int n2, int weight) {
        this.n1 = n1;
        this.n2 = n2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        return weight - e.weight;
    }
}
class Main{
    static int[] parent;

    static void union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1 < p2) parent[p2] = p1;
        else parent[p1] = p2;

    }
    static int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arg = br.readLine().split(" ");
        int N = Integer.parseInt(arg[0]);
        int M = Integer.parseInt(arg[1]);
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        StringTokenizer st;
        parent = new int[N + 1];
        for(int i = 1; i < N;i++){
            parent[i] = i;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            queue.add(new Edge(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        int answer = 0;

        while(!queue.isEmpty()){
            Edge e = queue.poll();

            if(find(e.n1) != find(e.n2)){
                union(e.n1, e.n2);
                answer += e.weight;
            }
        }
        System.out.println(answer);

    }
}