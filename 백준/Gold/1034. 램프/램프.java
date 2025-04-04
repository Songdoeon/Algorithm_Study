import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 1034 16:18 시작!
class Main{
    static int N, M;
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int K = Integer.parseInt(br.readLine());
        int ans = 0;
        for (String s : map.keySet()) {
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                if(s.charAt(i) == '0') cnt++;
            }
            if((cnt <= K) && ((cnt & 1) == (K & 1))){
                ans = Math.max(ans, map.get(s));
            }
        }
        System.out.println(ans);
    }
}