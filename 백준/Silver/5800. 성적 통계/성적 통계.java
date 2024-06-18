import java.io.*;
import java.util.*;


class Main {
    static int T, N;
    static int INF = 10_000_001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int gap = arr[1] - arr[0];
            for (int j = 2; j < N; j++) {
                gap = Math.max(gap, arr[j] - arr[j - 1]);
            }
            bw.write("Class " + i + "\n");
            bw.write("Max " + arr[N - 1] + ", Min " + arr[0]);
            bw.write(", Largest gap " + gap + "\n");
        }
        bw.flush();
    }
}