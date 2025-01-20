import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    static boolean check(long mid){
        long sum = 0;

        for(int i = 0 ; i < N ; i++){
            long n = arr[i];
            sum += (mid / n);
            if(sum >= M) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        int max = 1;
        int min = 1_000_000_000;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        long s = 1;
        long e = (long) max * M + 1;
        while (s < e){
            long mid = (s + e) / 2;

            if(check(mid)) {
                e = mid;
            }
            else {
                s = mid + 1;
            }
        }

        System.out.println(e);
    }
}
