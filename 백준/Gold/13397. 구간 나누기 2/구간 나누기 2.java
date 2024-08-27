import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    static int check(int mid){
        int cnt = 1;
        int s = 10_001;
        int e = 0;
        for (int i = 1; i <= N; i++) {
            s = Math.min(s, arr[i]);
            e = Math.max(e, arr[i]);

            if(e - s > mid) {
                i--;
                cnt++;
                s = 10_001;
                e = 0;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        int min = 10_001;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int s = 0;
        int e = (max - min) + 1;
        int mid;
        int ans = 0;
        while(s < e){
            mid = (s + e) / 2;
            int cnt = check(mid);
            if(cnt <= M){
                e = mid;
                ans = mid;
            }
            else {
                s = mid + 1;
            }
        }
        System.out.println(ans);
    }
}