import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R, X;
    static int[] arr;
    static int ans = 0;
    static Set<Integer> set = new HashSet<>();
    static void search(int depth, int max, int min, int sum){
        if (R < sum) return;
        if(depth == N){
            if(sum >= L && sum <= R && max - min >= X)ans++;
            return ;
        }
        int tempMax = Math.max(max, arr[depth]);
        int tempMin= Math.min(min, arr[depth]);
        search(depth+1, tempMax, tempMin, sum+arr[depth]);
        search(depth+1, max, min, sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        search(0, 0, 10_000_001, 0);
        System.out.println(ans);
    }
}
