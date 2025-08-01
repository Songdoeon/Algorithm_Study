import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 25918

public class Main {
    static int F, S, G, U, D;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new boolean[F + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(S);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int x = queue.poll();
                if(visited[x]) continue;
                visited[x] = true;
                if(x == G){
                    System.out.println(ans);
                    System.exit(0);
                }
                if (x - D > 0 && !visited[x - D]) queue.offer(x - D);
                if (x + U <= F && !visited[x + U]) queue.offer(x + U);
            }
            ans++;
        }
        System.out.println("use the stairs");
    }
}

