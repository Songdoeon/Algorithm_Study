import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
    int x, y, v, p;

    public Pos(int x, int y, int v, int p) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.p = p;
    }
}

public class Main {
    static int N, K, T;
    static Pos start;
    static Pos[] arr;
    static boolean[] visited;

    static boolean search(Pos p1, Pos p2){
        double reach = Math.sqrt(Math.pow(Math.abs(p1.x - p2.x), 2) + Math.pow(Math.abs(p1.y - p2.y), 2));
        if(reach <= K && Math.abs(p1.v - p2.v) <= T) return true;
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        arr = new Pos[N];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[i] = new Pos(x, y, v, p);
        }
        
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(start);
        Queue<Integer> ans = new PriorityQueue<>();
        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            for (int i = 0; i < N; i++) {
                if(visited[i]) continue;
                if(!search(cur, arr[i])) continue;
                visited[i] = true;
                if(arr[i].p == 1) ans.offer(i + 1);
                queue.offer(arr[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!ans.isEmpty()) sb.append(ans.poll()).append(' ');
        
        System.out.println(sb.length() == 0 ? 0 : sb);

    }
}
