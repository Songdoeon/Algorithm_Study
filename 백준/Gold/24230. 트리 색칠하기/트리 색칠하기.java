import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 24230

public class Main {
    static int N;
    static int[] target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        target = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        
        int ans = 0;
        if(target[1] != 0) ans++;
        
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(target[a] != target[b]) ans++;
        }

        System.out.println(ans);
    }
}
