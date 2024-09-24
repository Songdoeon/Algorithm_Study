import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long sum = 0;
        arr = new int[N];
        cnt = new int[21];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().length();
        }

        for (int i = 0; i < M; i++) {
            sum += cnt[arr[i]]++;
        }
        int s = 0;
        int e = M;

        while (e < N) {
            sum += cnt[arr[e++]]++;
            cnt[arr[s++]]--;
        }

        System.out.println(sum);

    }
}