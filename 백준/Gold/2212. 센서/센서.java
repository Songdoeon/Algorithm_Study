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
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        for (int i = 1; i < N; i++) {
            queue.offer(arr[i] - arr[i - 1]);
        }
        int ans = 0;
        int count = N - K;
        while(count-- > 0) {
            ans += queue.poll();
        }
        System.out.println(ans);
    }
}