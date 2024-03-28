import java.util.*;
import java.io.*;
public class Solution {
    static int T;
    static final int INF = 1001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        int N;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 0 && i != j) arr[i][j] = INF;
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }

            int result = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    if(i == j) continue;
                    sum += arr[i][j];
                }
                result = Math.min(result, sum);
            }
            sb.append("#").append(t).append(' ').append(result).append('\n');
        }
        System.out.println(sb);
    }
}
