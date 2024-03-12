import java.io.*;
import java.util.*;
public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        for (int i = 0; i < M; i++) {
            String num = br.readLine();
            map1.put(num, i);
            map2.put(i, num);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(map1.values());

        for (int i = 0; i < N; i++) {
            if(pq.isEmpty())break;
            sb.append(map2.get(pq.poll())).append('\n');
        }
        System.out.println(sb);
    }
}