import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        int e = N - 1;
        int ans = 200_000_001;
        while (s < e){
            int sum = arr[s] + arr[e];
            if(Math.abs(sum) < Math.abs(ans)){
                ans = sum;
                if(sum < 0) s++;
                else e--;
            }
            else if(sum > 0)e--;
            else s++;
        }
        System.out.println(ans);
    }
}
