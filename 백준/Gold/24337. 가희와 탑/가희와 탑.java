import java.io.*;
import java.util.*;

public class Main {
    static int N, A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        if (N < A + B - 1) {
            System.out.println(-1);
            return;
        }

        int max = Math.max(A, B);
        int e = N - (A + B - 1);

        if(A == 1){
            sb.append(max).append(' ');
            for (int i = 0; i < e; i++) sb.append('1').append(' ');
            int h = B - 1;
            while (B-- > 1){
                sb.append(h--).append(' ');
            }
        }
        else {
            for (int i = 0; i < e; i++) {
                sb.append('1').append(' ');
            }

            int h = 1;

            while (h < A){
                sb.append(h++).append(' ');
            }

            sb.append(max).append(' ');

            h = B - 1;
            while (B-- > 1){
                sb.append(h--).append(' ');
            }
        }

        System.out.println(sb);
    }
}
