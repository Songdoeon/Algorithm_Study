import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] cnt;
    static int offset = 1_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        cnt = new int[2_000_001];
        for (int i = 0; i < N; i++) {
            cnt[Integer.parseInt(br.readLine()) + offset]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 2_000_000; i++) {
            if(cnt[i] != 0)sb.append((i - offset)).append('\n');
        }
        System.out.println(sb);
    }
}
