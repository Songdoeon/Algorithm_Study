import java.util.*;
import java.io.*;

public class Main
{
    static int N, K, C, temp, count = 0, sum = 0;
    static int input[], dp[], before[];
    static boolean check[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        input = new int[N+1];
        dp = new int[N+1];
        before = new int[N+1];
        check = new boolean[N+1];
        
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        for(int i=1;i<=N;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++){
            dp[i] = dp[i-1]+input[i];
        }
            
        // 예외상황 처리
        if(N<K || (N==K && C>=input[N]) ){
            sb.append(input[N]).append("\n").append(0).append("\n");
            System.out.print(sb);
            return;
        }else if(N==K){
            sb.append(C).append("\n").append(1).append("\n").append(1);
            System.out.print(sb);
            return;
        }
            
        
        for(int j=K;j<=N;j++){
            if(dp[j-1]+input[j] > dp[j-K]+C){
                dp[j] = dp[j-K]+C;
                before[j] = -(j-K);
                // list[j] = list[j-K]+(j-K+1)+" ";
            }else{
                dp[j] = dp[j-1]+input[j];
                before[j] = j-1;
                // list[j] = list[j-1];
            }
        }
        
        // System.out.print(Arrays.toString(dp));
        
        temp = N;
        while(before[temp]!=0){
            
            if(before[temp] < 0) {
                check[-before[temp]+1] = true;
                count++;
                temp = -before[temp];
            }
            else temp = before[temp];
            
            if(temp == K && before[temp]==0 && dp[K] != dp[K-1]+input[K]){
                check[1] = true;
                count++;
                temp = 0;
            }
        }
        
        sb.append(dp[N]).append("\n").append(count).append("\n");
        
        for(int i=1;i<=N;i++){
            if(check[i]) sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}
