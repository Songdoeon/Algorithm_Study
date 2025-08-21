import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1715

public class Main {
    static int N, K;
    static int[] arr;

    static int calc(int mid){
        int sum = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if(sum >= mid){
                count++;
                sum = 0;
            }
        }
        return count;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int min = 0;
        int max = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max += arr[i];
        }

        int ans = 0;
        while(min < max){
            int mid = (min + max) / 2;
            int group = calc(mid);
            if(group < K){
                max = mid;
            }
            else{
                min = mid + 1;
                if(group == K) ans = Math.max(ans, mid);
            }
        }
        System.out.println(ans);

    }
}