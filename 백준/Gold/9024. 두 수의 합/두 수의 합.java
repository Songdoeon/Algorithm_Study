import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N];
            long ans = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int s = 0;
            int e = N - 1;
            int flag = Integer.MAX_VALUE;
            while (s < e){
                int sum = arr[s] + arr[e];

                int diff = Math.abs(M - sum);
                if(diff < flag){
                    ans = 1;
                    flag = diff;

                }
                else if(diff == flag) {
                    ans++;
                }
                
                if(M >= sum) s++;
                else e--;
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);

    }
}
