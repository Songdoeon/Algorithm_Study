import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 2565 : 21:25 시작

public class Main {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[N];
        int idx = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            for(int j = 0; j <= idx; j++) {
                if(arr[i][1] < dp[j]){
                    if(j == idx)idx++;
                    dp[j] = arr[i][1];
                    break;
                }
            }
        }
        System.out.println(N - idx);
    }
}

