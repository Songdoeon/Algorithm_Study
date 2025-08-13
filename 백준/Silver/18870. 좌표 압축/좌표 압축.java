import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        arr[0][2] = 0;
        for (int i = 1; i < N; i++) {
            if(arr[i][0] == arr[i - 1][0]) arr[i][2] = arr[i - 1][2];
            else arr[i][2] = arr[i - 1][2] + 1;
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        for (int i = 0; i < N; i++) sb.append(arr[i][2]).append(' ');

        System.out.println(sb);
    }
}
