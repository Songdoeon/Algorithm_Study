import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        cnt = new int[N + 1];
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += arr[i];
            sb.append(arr[i]).append(" ");
            cnt[arr[i]] += arr[i];
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if(max < cnt[i]) {
                max = cnt[i];
            }
        }
        ans += max;
        System.out.println(ans + "\n" + sb);
    }
}
