import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr = new int[1_000_002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s]++;
            arr[e + 1]--;
        }
        for (int i = 1; i < 1_000_002; i++) {
            arr[i] += arr[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sb.append(arr[Integer.parseInt(st.nextToken())]).append('\n');
        }
        System.out.println(sb);
    }
}
