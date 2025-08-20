import java.io.*;
import java.util.*;

// 1715

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int ans = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) queue.offer(Integer.parseInt(br.readLine()));


        while (queue.size() > 1) {
            int num = queue.poll() + queue.poll();
            ans += num;
            queue.offer(num);
        }

        System.out.println(ans);
    }
}