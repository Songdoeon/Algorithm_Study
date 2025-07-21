import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 1270

public class Main {
    static int N;
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());

            boolean found = false;
            String ans = null;
            int flag = c / 2;
            for (int j = 0; j < c; j++) {
                String n = st.nextToken();
                map.put(n, map.getOrDefault(n, 0) + 1);
                int value = map.get(n);
                if(value > flag) {
                    found = true;
                    ans = n;
                    break;
                }
            }
            sb.append(!found ? "SYJKGW" : ans).append('\n');
            map.clear();
        }
        System.out.println(sb);
    }
}