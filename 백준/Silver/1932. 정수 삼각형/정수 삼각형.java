import java.io.*;
import java.util.*;
public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] dp = new int[N + 1][N + 1];
        int idx;
        dp[1][1] = Integer.parseInt(br.readLine());

        for(int i = 2; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            idx = 1;
            while(st.hasMoreTokens()){
                int n = Integer.parseInt(st.nextToken());
                dp[i][idx] = n + Math.max(dp[i - 1][idx],dp[i - 1][idx - 1]);
                idx++;
            }
        }
        int answer = 0;
        for(int n : dp[N]){
            if(n > answer) answer = n;
        }
        System.out.println(answer);
    }
}
