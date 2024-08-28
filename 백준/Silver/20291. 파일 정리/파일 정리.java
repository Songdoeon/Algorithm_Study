import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] arg = br.readLine().split("\\.");
            map.put(arg[1], map.getOrDefault(arg[1], 0) + 1);
        }

        Queue<String> q = new PriorityQueue<>(map.keySet());

        while (!q.isEmpty()) {
            String key = q.poll();
            sb.append(key).append(' ').append(map.get(key)).append("\n");
        }


        System.out.println(sb);
    }
}