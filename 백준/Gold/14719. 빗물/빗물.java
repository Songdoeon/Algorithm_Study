import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        int ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < M - 1; i++) {
            int l = i - 1;
            int r = i + 1;
            int left = arr[l];
            int right = arr[r];
            while (l >= 0){
                left = Math.max(left, arr[l]);
                l--;
            }
            while (r < M){
                right = Math.max(right, arr[r]);
                r++;
            }
            int high = Math.min(left, right);
            if(high < arr[i]) continue;
            ans += Math.min(right, left) - arr[i];
        }
        System.out.println(ans);
    }
}
