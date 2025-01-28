import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N == 0) {
            System.out.println(0);
            return ;
        }
        st = new StringTokenizer(br.readLine());
        int ans = 1;
        int weight = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(weight + n > M) {
                weight = n;
                ans++;
            }
            else weight += n;
        }
        System.out.println(ans);
    }
}
