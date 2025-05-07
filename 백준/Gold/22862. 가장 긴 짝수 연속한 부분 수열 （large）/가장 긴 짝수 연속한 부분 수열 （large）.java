import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 22862 - 09:50 시작

public class Main {
    static int N, M;
    static boolean[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) % 2 == 0;
        }
        int s = 0;
        int e = 0;
        int count = 0;
        int ans = 0;
        while (e < N){
            if(!arr[e]){
                count++;
                ans = Math.max(ans, e - s + 1 - count);
                while (count > M){
                    if(!arr[s++])count--;
                }
            }
            e++;
        }
        ans = Math.max(ans, e - s - count);
        System.out.println(ans);
    }
}