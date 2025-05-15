import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        int ans = 1;
        int n = 1, m = 1, l = 1;
        while (n != N || m != M || l != L) {
            ans++;
            if(++n > 15) n = 1;
            if(++m > 28) m = 1;
            if(++l > 19) l = 1;
        }

        System.out.print(ans);
    }
}
