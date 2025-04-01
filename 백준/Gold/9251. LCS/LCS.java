import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 14:25 시작
class Main{
    static char[] s1, s2;
    static int len1, len2;
    static int[][] dp;
    static int search(int idx1, int idx2){
        if(idx1 < 0 || idx2 < 0) return 0;

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        dp[idx1][idx2] = s1[idx1] == s2[idx2] ?
                search(idx1 - 1, idx2 - 1) + 1 :
                Math.max(search(idx1 - 1, idx2), search(idx1, idx2 - 1));
        return dp[idx1][idx2];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();

        len1 = s1.length;
        len2 = s2.length;

        dp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(search(len1 - 1, len2 - 1));
    }
}