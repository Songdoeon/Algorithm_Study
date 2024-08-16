import java.io.*;
import java.util.*;

class Main {
    static int T, N;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            boolean find = false;
            N = Integer.parseInt(br.readLine());
            arr = new String[N];
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine();
            }
            Arrays.sort(arr, String::compareTo);
            for (int i = 0; i < N - 1; i++) {
                if (arr[i + 1].startsWith(arr[i])) {
                    find = true;
                    break;
                }
            }
            if (find) sb.append("NO").append('\n');
            else sb.append("YES").append('\n');
        }
        System.out.println(sb);
    }
}