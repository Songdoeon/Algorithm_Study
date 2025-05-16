import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, L;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }
        int w = 0;
        int ans = 0;
        Queue<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            bridge.offer(0);
        }
        while (!queue.isEmpty()) {
            int x = queue.peek();
            w -= bridge.poll();
            ans++;

            if(w + x <= L){
                bridge.offer(x);
                w += queue.poll();
            }
            else{
                bridge.offer(0);
            }
        }
        System.out.print(ans + M);
    }
}
