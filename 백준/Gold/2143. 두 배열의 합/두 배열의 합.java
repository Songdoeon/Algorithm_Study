import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    static int T, N, M;
    static int[] arr1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map1 = new HashMap<>();
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        arr1 = new int[N + 1];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr1[i] = arr1[i - 1] + n;
            for (int j = 0; j < i; j++) {
                int num = arr1[i] - arr1[j];
                map1.put(num, map1.getOrDefault(num, 0) + 1);
            }
        }
        M = Integer.parseInt(br.readLine());
        arr1 = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        long ans = 0;
        for (int i = 1; i <= M; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr1[i] = arr1[i - 1] + n;
            for (int j = 0; j < i; j++) {
                int num = arr1[i] - arr1[j];
                if(map1.containsKey(T - num)) ans += map1.get(T - num);
            }
        }
        System.out.println(ans);
    }
}
