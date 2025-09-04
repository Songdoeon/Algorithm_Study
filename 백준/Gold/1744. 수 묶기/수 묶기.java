import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// 15927

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Queue<Integer> queue1 = new PriorityQueue<>();
        Queue<Integer> queue2 = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n <= 0) queue1.offer(n);
            else queue2.offer(n);
        }

        int ans = 0;

        while(!queue1.isEmpty()){
            int cur = queue1.poll();
            if(queue1.isEmpty()) ans += cur;
            else ans += cur * queue1.poll();
        }
        while(!queue2.isEmpty()){
            int cur = queue2.poll();
            if(queue2.isEmpty()) ans += cur;
            else if(queue2.peek() != 1) ans += cur * queue2.poll();
            else ans += cur;
        }
        System.out.println(ans);
    }
}
