import java.util.*;
import java.io.*;

class Node {
    int v;
    int cost;

    public Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}
public class Main {
    static int T, N, M, W;
    static int INF = 25_000_001;
    static List<Node>[] list;
    static int[] dist;
    static boolean search(){
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean check = false;
        for (int j = 1; j < N; j++) {
            check = false;
            for (int k = 1; k <= N; k++) {
                for (Node n : list[k]) {
                    if(dist[n.v] >= dist[k] + n.cost){
                        dist[n.v] = dist[k] + n.cost;
                        check = true;
                    }
                }
            }
            if(!check)break;
        }
        if(check){
            for (int i = 1; i <= N; i++) {
                for (Node n : list[i]) {
                    if (dist[n.v] > dist[i] + n.cost) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T --> 0){

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            list = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                list[s].add(new Node(e, t));
                list[e].add(new Node(s, t));
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                list[s].add(new Node(e, -t));
            }
            if(search()) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        System.out.println(sb);
    }
}
