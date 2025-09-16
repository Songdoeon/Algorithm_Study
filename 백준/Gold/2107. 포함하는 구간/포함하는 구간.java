import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2107

public class Main {
    static int N, M;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int e = arr[i][1];
            int count = 0;
            for (int j = i + 1; j < N; j++) {
                if(e > arr[j][1]) count++;
                else if(e < arr[j][0]) break;
            }
            ans = Math.max(count, ans);
        }
        System.out.println(ans);
    }
}
