import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N, result;
    static int[] arr, dp, reverse;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        reverse = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp[i]<=dp[j]) dp[i] = dp[j]+1;
            }
        }
        
        for (int i = N-2; i >= 0; i--) {
            for (int j = N-1; j > i; j--) {
                if(arr[i] > arr[j] && reverse[i] <= reverse[j]) reverse[i] = reverse[j]+1;
            }
        }
        
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[i]+reverse[i]);
        }
        
        System.out.println(result+1);
    }

}