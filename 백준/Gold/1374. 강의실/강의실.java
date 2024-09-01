import java.io.*;
import java.util.*;
class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[] starts = new int[N];
        int[] ends = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            starts[i] = Integer.parseInt(st.nextToken());
            ends[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int idx = 0;

        int ans = 0;
        int ret = 0;
        for (int i = 0; i < N; i++) {
            ret++;
            while (idx < N && starts[i] >= ends[idx]) {
                idx++;
                ret--;
            }
            if (ans < ret){
                ans = ret;
            }
        }
        System.out.println(ans);
    }
}