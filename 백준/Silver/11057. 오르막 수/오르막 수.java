import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11057

public class Main {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][10];

        for (int i = 0; i < 10; i++) arr[1][i] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    arr[i][j] += arr[i - 1][k] % 10007;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) sum += arr[N][i] % 10007;

        System.out.println(sum % 10007);

    }
}