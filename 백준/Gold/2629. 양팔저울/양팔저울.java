import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2629 12:10 시작!

class Main{
    static int N, M;
    static int[] arr;
    static int[][] dp;
    static void search(int idx, int num){
        if(dp[idx][num] != 0) return ;
//        System.out.println(idx + " : " + num);
        dp[idx][num]++;
        if(idx >= N) return;
        search(idx + 1, num);
        search(idx + 1, num + arr[idx + 1]);
        search(idx + 1, Math.abs(num - arr[idx + 1]));
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1][40_001];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        search(0, 0);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int n = Integer.parseInt(st.nextToken());
            for(int j = 0; j <= N; j++){
                if(dp[j][n] != 0) {
                    find = true;
                    break;
                }
            }
            if(!find) sb.append("N ");
            else sb.append("Y ");
        }
        System.out.println(sb);
    }
}