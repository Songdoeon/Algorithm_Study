import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 14908

public class Main {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = i + 1;
        }

        Arrays.sort(arr, (a, b) -> a[0] * b[1] != a[1] * b[0] ? a[0] * b[1]  - a[1] * b[0] : 1);

        for (int i = 0; i < N; i++) {
            sb.append(arr[i][2]).append(' ');
        }

        System.out.println(sb);
    }
}
