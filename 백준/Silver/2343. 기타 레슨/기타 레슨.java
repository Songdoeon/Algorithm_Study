import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2343

public class Main {
    static int N, M;
    static int[] arr;

    static int calc(int mid){
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if(sum > mid){
                cnt++;
                sum = arr[i];
            }

        }
        if(sum > 0)cnt++;
        return cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int e = 1;
        int s = 1;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            e += arr[i];
            s = Math.max(s, arr[i]);
        }
        
        int ans = e + 1;
        while (s < e) {
            int mid = (s + e) / 2;
            int cnt = calc(mid);
            if(cnt <= M){
                ans = Math.min(ans, mid);
                e = mid;
            }else{
                s = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
