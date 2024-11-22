import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean check(int mid){
        int cur = arr[0];
        int len = 0;
        int count = 1;
        for (int i = 1; i < N; i++) {
            len += (arr[i] - cur);
            if(len >= mid){
//                System.out.println(arr[i]);
//                if(count++ > M) return false;
                count++;
                len = 0;
            }
            cur = arr[i];
        }
//        System.out.println("----------");
        return count >= M;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int s = 1;
        int e = arr[N - 1] + 1;
        int ans = 0;
        while(s < e){
            int mid = (s + e) / 2;
            if(!check(mid)){
                e = mid;
            }
            else {
                ans = Math.max(ans, mid);
                s = mid + 1;
            }
        }
        System.out.println(ans);

    }
}
