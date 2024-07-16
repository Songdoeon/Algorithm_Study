import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        int ans1 = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 6; i++) {
            ans1 += arr[i] % n == 0 ? (arr[i] / n) : (arr[i] / n) + 1;
        }
        sb.append(ans1).append('\n');
        sb.append(N / m).append(' ').append(N % m);
        System.out.println(sb);
    }
}