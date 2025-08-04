import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int s = 0;
        int e = 1;
        int ans = 2_000_000_001;
        while (s < N && e < N){
            int n1 = arr[s];
            int n2 = arr[e];
            int num = n2 - n1;
            if(num >= M){
                ans = Math.min(ans, num);
                s++;
            }
            else {
                e++;
            }
        }
        System.out.print(ans);
    }
}
