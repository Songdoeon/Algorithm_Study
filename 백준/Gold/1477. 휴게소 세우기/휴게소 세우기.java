import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, L;
    static int[] arr;

    static boolean check(int mid){
        int cnt = 0;
        int len = 0;
        int idx = 1;
        while(cnt <= M){
            len += mid;
            if(len >= L) return true;
            if(len >= arr[idx]){
                len = arr[idx++];
                continue;
            }
            cnt++;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N + 2];
        arr[0] = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[N] = L;
        Arrays.sort(arr);
        int s = 1;
        int e = L + 1;

        int ans = 0;
        while(s < e){
            int mid = (s + e) / 2;
            if(check(mid)){
                e = mid;
                ans = Math.max(0, mid);
            }
            else{
                s = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
