import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }
        while (!queue.isEmpty()) {
            
            sb.append(queue.poll()).append(' ');
        }
        System.out.println(sb);
    }
}
