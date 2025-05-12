import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// 16439

public class Main {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        int len = str.length();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        Queue<String> queue = new PriorityQueue<>(String::compareTo);
        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                sb1.append(str, 0, i);
                sb2.append(str, i, j);
                sb3.append(str.substring(j));
                queue.offer(sb1.reverse() + sb2.reverse().toString() + sb3.reverse().toString());
                sb1.setLength(0);
                sb2.setLength(0);
                sb3.setLength(0);
            }
        }
        System.out.println(queue.poll());
    }
}
