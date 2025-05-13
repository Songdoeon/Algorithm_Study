import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    static long check(long mid){
        long ret = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i] > mid) ret += arr[i] - mid;
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int high = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(arr[i], high);
        }

        long s = 0;
        long e = high + 1;
        long ans = 0;
        while (s < e){
            long mid = (s + e) / 2;
            if(check(mid) >= M){
                ans = Math.max(ans, mid);
                s = mid + 1;
            }
            else e = mid;
        }
        System.out.println(ans);
    }
}
