import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int ans = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ans = Math.max(ans, Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
        }
        System.out.println(ans);
    }
}