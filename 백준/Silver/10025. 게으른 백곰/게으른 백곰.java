import java.io.*;
import java.util.*;

public class Main {
    static int T, N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long[] arr = new long[1_000_001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            arr[index] += n;
        }
        int start = 0;
        int end = 2 * M + 1;
        end = Math.min(1_000_000, end);
        long sum = 0;
        for (int i = 0; i < end; i++) {
            sum += arr[i];
        }

        long result = sum;
        while (end <= 1_000_000){
            sum -= arr[start++];
            sum += arr[end++];
            result = Math.max(sum, result);
        }

        System.out.println(result);
    }
}