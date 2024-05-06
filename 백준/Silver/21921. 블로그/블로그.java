import java.util.*;
import java.io.*;

class Main{
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        int max = sum;
        int ans = 1;
        for (int i = M; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum -= arr[i - M];
            sum += arr[i];
            if(sum > max){
                max = sum;
                ans = 1;
            }else if(sum == max){
                ans++;
            }
        }
        System.out.println(max == 0 ? "SAD" : max + "\n" + ans);
    }
}