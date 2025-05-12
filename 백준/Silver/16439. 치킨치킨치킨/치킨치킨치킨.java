import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

// 16439

public class Main {
    static int N, M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for (int a = 0; a < M; a++) {
            for (int b = a + 1; b < M; b++) {
                for (int c = b + 1; c < M; c++) {
                    int sum = 0;
                    for (int i = 0; i < N; i++) {
                        sum += Math.max(arr[i][a],
                                Math.max(arr[i][b], arr[i][c]));
                    }
                    ans = Math.max(ans, sum);
                }
            }
        }
        System.out.println(ans);
    }
}
