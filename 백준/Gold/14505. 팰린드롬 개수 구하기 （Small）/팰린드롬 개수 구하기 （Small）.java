import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 14:25 시작
class Main{
    static char[] s;
    static int len;
    static int[][] dp;
    static int search(int start, int end){
        if(start == end) return 1;
        if(dp[start][end] != -1) return dp[start][end];
        int ret = 0;
        for (int i = start; i <= end; i++) {
            for (int j = i; j <= end; j++) {
                if(s[i] == s[j]){
                    ret++;
                    if(i + 2 <= j) ret += search(i + 1, j - 1);
                }
            }
        }
        return dp[start][end] = ret;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine().toCharArray();

        len = s.length;
        dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(search(0, len - 1));
    }
}