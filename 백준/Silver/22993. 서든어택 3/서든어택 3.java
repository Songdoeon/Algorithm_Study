import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long joon = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < N; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i < N; i++) {
            int next = queue.poll();
            if(joon <= next) {
                System.out.println("No");
                return;
            }
            joon += next;
        }

        System.out.println("Yes");
    }
}
