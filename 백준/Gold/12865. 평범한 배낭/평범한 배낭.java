import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] items = new int[N + 1][2];
        int[][] dp = new int[N + 1][K + 1];
        
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= K; j++){            
                dp[i][j] = (j - items[i][0]) >= 0 ? Math.max(dp[i - 1][j], items[i][1] + dp[i - 1][j - items[i][0]]) : dp[i - 1][j];
            }
        }

        System.out.println(dp[N][K]);
    }
}
