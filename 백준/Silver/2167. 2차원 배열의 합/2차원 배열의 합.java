import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken()) - 1;
            int s2 = Integer.parseInt(st.nextToken()) - 1;
            int e1 = Integer.parseInt(st.nextToken()) - 1;
            int e2 = Integer.parseInt(st.nextToken()) - 1;
            int sum = 0;
            for (int i = s1; i <= e1; i++) {
                for (int j = s2; j <= e2; j++) {
                    sum += arr[i][j];
                }
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}
