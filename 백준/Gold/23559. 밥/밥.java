import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()) - (1000 * N);
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = x - y;
            sum += y;
        }
        Arrays.sort(arr);
        int idx = N - 1;
        while (M >= 4000){
            if(arr[idx] <= 0) break;
            M -= 4000;
            sum += arr[idx--];
        }
        System.out.println(sum);
    }
}