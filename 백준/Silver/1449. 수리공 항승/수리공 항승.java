import java.io.*;
import java.util.*;
class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()) - 1;
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans = 1;
        int idx = arr[0];
        for (int i = 1; i < N; i++) {
            if(arr[i] <= idx + M) continue;
            idx = arr[i];
            ans++;
        }

        System.out.println(ans);
    }
}
