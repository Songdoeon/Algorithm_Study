import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>();
        arr = new boolean[100_001];

        long total = 0;
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(br.readLine());
            queue.offer(n);
        }
        int idx = 1;
        while (!queue.isEmpty()){
            int n = queue.poll();
            if(arr[n]) continue;
            if(idx != n) {
                int diff = n - idx;
                total += diff;
                arr[n - idx] = true;
            }
            else arr[n] = true;
            idx++;
        }
        System.out.println(total);
    }
}