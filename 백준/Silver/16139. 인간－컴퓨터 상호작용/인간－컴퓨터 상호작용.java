import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16139

public class Main {
    static int[][] arr;
    static int N, len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String s = br.readLine();
        len = s.length();
        N = Integer.parseInt(br.readLine());
        arr = new int[len + 1][26];
        for (int i = 1; i <= len; i++) {
            int c = s.charAt(i - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                arr[i][j] = arr[i - 1][j];
            }
            arr[i][c]++;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) + 1;
            sb.append(arr[end][c] - arr[start][c]).append('\n');
        }

        System.out.println(sb);
    }
}
