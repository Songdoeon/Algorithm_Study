import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N == 0) {
            System.out.println(0);
            return ;
        }
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int ans = 1;
        int weight = 0;
        for (int i = 0; i < N; i++) {
            if(weight + arr[i] > M) {
                weight = arr[i];
                ans++;
            }
            else weight += arr[i];
        }
        System.out.println(ans);
    }
}
