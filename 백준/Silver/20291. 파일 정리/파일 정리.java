import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String exec = br.readLine();
            String arg = exec.substring(exec.indexOf('.') + 1);
            map.put(arg, map.getOrDefault(arg, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(' ').append(entry.getValue()).append("\n");

        }

        System.out.println(sb);
    }
}