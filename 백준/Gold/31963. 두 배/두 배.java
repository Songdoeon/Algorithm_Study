import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 31963 - 17:00 시작

public class Main {
    static int N;
    static long[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long ans = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[i - 1] > arr[i]){
                long diff = (arr[i - 1] + arr[i] - 1) / arr[i];
                int k = Long.SIZE - Long.numberOfLeadingZeros(diff - 1);
                ans += k;
                arr[i] <<= k;
            }
        }
        System.out.println(ans);
    }
}