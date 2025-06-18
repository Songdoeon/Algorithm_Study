import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        if(N <= K) {
            System.out.println(0);
            return ;
        }
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        for (int i = 1; i < N; i++) {
            queue.offer(new int[] {arr[i] - arr[i - 1], i});
        }

        int[] index = new int[K];
        int idx = 0;
        while(!queue.isEmpty() && --K > 0) {
            int[] cur = queue.poll();
            index[idx++] = cur[1];
        }
        Arrays.sort(index, 0, idx);
        int start = arr[0];
        int ans = 0;
        for (int i = 0; i < idx; i++) {
            ans += arr[index[i] - 1] - start;
            start = arr[index[i]];
        }
        if(index[idx] != N - 1) ans += arr[N - 1] - start;
        System.out.println(ans);
    }
}