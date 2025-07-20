import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14653

public class Main {
    static int N, K, Q;
    static int[][] arr;
    static boolean[] count = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new int[K + 1][2];
        count[0] = true;
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = st.nextToken().charAt(0) - 'A';
            if(Q <= i) {
                if(arr[i - 1][0] == arr[i][0]) count[arr[i - 1][1]] = true;
                count[arr[i][1]] = true;
            }
        }
        if(arr[Q][0] == 0) System.out.println(-1);
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) if(!count[i]) sb.append((char)('A' + i)).append(' ');
            System.out.println(sb);
        }
    }
}