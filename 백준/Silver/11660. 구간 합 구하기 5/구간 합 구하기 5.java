import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int i, j, x1, x2, y1, y2;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];
        for(i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(j = 1; j <= N; j++) arr[i][j] = Integer.parseInt(st.nextToken()) 
                                                    + arr[i - 1][j]
                                                    + arr[i][j - 1]
                                                    - arr[i - 1][j - 1];
        }

        for(i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken()) - 1;
            y1 = Integer.parseInt(st.nextToken()) - 1;
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            sb.append(arr[x2][y2] - arr[x2][y1] - arr[x1][y2] + arr[x1][y1]).append('\n');
        }
        System.out.print(sb.toString());
    }
}
