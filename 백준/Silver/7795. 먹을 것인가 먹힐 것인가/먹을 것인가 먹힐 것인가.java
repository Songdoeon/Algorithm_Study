import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 7795

public class Main {
    static int T, N, M;
    static int[] arr1, arr2;

    static int search(int idx){
        int n = arr1[idx];

        int s = 0;
        int e = M;

        while (s < e){
            int mid = (s + e) / 2;
            int target = arr2[mid];
            if(n <= target){
                e = mid;
            }
            else{
                s = mid + 1;
            }
        }
        return e;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr1 = new int[N];
            arr2 = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr1[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) arr2[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int max = arr2[M - 1];
            int min = arr2[0];

            int ans = 0;

            for (int i = 0; i < N; i++) {
                if(arr1[i] > max) {
                    ans += (N - i) * M;
                    break;
                }
                else if (arr1[i] > min){
                    ans += search(i);
                }
            }

            sb.append(ans).append('\n');

        }

        System.out.println(sb);
    }
}
