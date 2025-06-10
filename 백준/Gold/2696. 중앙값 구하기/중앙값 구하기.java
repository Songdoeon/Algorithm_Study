import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 2696

public class Main {
    static int T, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        Queue<Integer> q1;
        Queue<Integer> q2;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            q1 = new PriorityQueue<>();
            q2 = new PriorityQueue<>((a, b) -> b - a);
            N = Integer.parseInt(st.nextToken());
            sb.append((N + 1) / 2).append('\n');
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            while (cnt++ < N){
                if(cnt != 1 && cnt % 10 == 1) st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                if(q1.isEmpty()) {
                    q1.add(n);
                }
                else if(n < q1.peek()){
                    q2.offer(n);
                }
                else {
                    q1.offer(n);
                }
                if(cnt % 2 == 1){
                    while(q1.size() <= q2.size()){
                        q1.offer(q2.poll());
                    }
                    while(q1.size() > q2.size() + 1){
                        q2.offer(q1.poll());
                    }
                    sb.append(q1.peek()).append(' ');
                }
                if(cnt % 20 == 0)sb.append('\n');
            }
            sb.append('\n');

        }

        System.out.println(sb);
    }
}
