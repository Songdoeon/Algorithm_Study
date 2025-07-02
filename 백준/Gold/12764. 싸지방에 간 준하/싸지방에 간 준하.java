import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 2871

public class Main {
    static int N;
    static int[][] arr;
    static int max = 0;
    static int[] count, ends;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = new int[N];
        ends = new int[N];
        StringTokenizer st;

        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int idx;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Queue<Integer> empty = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int[] info = arr[i];
            while(!queue.isEmpty() && queue.peek()[0] < info[0]) {
                empty.offer(queue.poll()[1]);
            }
            if(empty.isEmpty()) idx = max;
            else idx = empty.poll();
            queue.offer(new int[]{info[1], idx});
            count[idx]++;
            if(idx >= max){
                max++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max).append('\n');
        for (int i = 0; i < max; i++) {
            sb.append(count[i]).append(' ');
        }

        System.out.println(sb);
    }
}
