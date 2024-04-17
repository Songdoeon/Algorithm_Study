import java.util.*;
import java.io.*;

class Main {
    static int T, N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        Deque<Integer> stack;
        while (T-- > 0){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            long sum = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            N--;
            while (N > 0){
                int n = arr[N];
                if(arr[N - 1] >= n){
                    N--;
                    continue;
                }
                while (N > 0 && arr[N - 1] < n) {
                    sum += n - arr[N-- - 1];
                }
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}