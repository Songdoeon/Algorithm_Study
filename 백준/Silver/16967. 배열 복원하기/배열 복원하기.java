import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static int N, M, X, Y;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) + N;
        Y = Integer.parseInt(st.nextToken()) + M;

        int[][] ans = new int[N][M];
        int[][] arr = new int[X][Y];

        for (int i = 0; i < X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < Y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = X - N; i < N; i++) {
            for (int j = Y - M; j < M; j++) {
                arr[i][j] -= arr[i - X + N][j - Y + M];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(ans[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
