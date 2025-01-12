import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int end = arr[N - 1];
        int ans = 0;
        for (int i = N - 2; i >= 0; i--) {
            if(arr[i] >= end){
                ans += arr[i] - (end - 1);
                end--;
            }
            else end = arr[i];
        }
        System.out.println(ans);
    }
}