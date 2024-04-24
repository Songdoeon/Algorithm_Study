import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, K, N, a, g, c, t, ans;
    static Map<Long, Integer> dna;
    static String str;
    static final long H = 601;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            str = st.nextToken();
            sb.append(solution()).append("\n");
            System.gc();
        }
        System.out.print(sb);
    }

    public static int solution() {
        ans = 0;
        N = str.length() - K;
        dna = new HashMap<>();
        
        a = 0;
        g = 0;
        c = 0;
        t = 0;

        for (int i = 0; i < K; i++) add(str.charAt(i));
        set();
        
        for (int i = 0; i < N; i++) {
            sub(str.charAt(i));
            add(str.charAt(i + K));
            set();
        }
        return ans;
    }

    static void add(char ch) {
        if (ch == 'A') a++;
        else if (ch == 'G') g++;
        else if (ch == 'C') c++;
        else if (ch == 'T') t++;
    }

    static void sub(char ch) {
        if (ch == 'A') a--;
        else if (ch == 'G') g--;
        else if (ch == 'C') c--;
        else if (ch == 'T') t--;
    }

    static void set() {
        long hash = (H * H * H * a) + (H * H * g) + (H * c) + t;
        if (!dna.containsKey(hash)) dna.put(hash, 0);
        int v = dna.get(hash) + 1;
        ans = Math.max(ans, v);
        dna.put(hash, v);
    }
}