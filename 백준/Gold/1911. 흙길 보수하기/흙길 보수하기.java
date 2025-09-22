import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1911

public class Main {
    static int N, M;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int pos = 0;
        long ans = 0;
        for (int i = 0; i < N; i++) {
            int s = arr[i][0];
            int e = arr[i][1];
            if (pos < s) pos = s;
            if (pos >= e) continue;

            int len = e - pos;
            int cnt = (len + M - 1) / M;
            ans += cnt;
            pos += cnt * M;
        }

        System.out.println(ans);
    }
}
