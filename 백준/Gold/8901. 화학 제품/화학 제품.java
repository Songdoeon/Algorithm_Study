import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int abP = Integer.parseInt(st.nextToken());
            int bcP = Integer.parseInt(st.nextToken());
            int caP = Integer.parseInt(st.nextToken());

            int ans = 0;
            int maxAB = Math.min(A, B);
            for (int abNum = 0; abNum <= maxAB; abNum++) {
                int aRem = A - abNum;
                int bRem = B - abNum;

                int bcNum = Math.min(bRem, C);
                int caNum = Math.min(aRem, C - bcNum);
                ans = Math.max(ans, abNum * abP + bcNum * bcP + caNum * caP);

                caNum = Math.min(aRem, C);
                bcNum = Math.min(bRem, C - caNum);
                ans = Math.max(ans, abNum * abP + bcNum * bcP + caNum * caP);
            }

            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
