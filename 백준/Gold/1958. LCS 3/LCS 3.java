import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 14:25 시작
class Main{
    static char[] s1, s2, s3;
    static int len1, len2, len3;
    static int[][][] dp;
    static int search(int idx1, int idx2, int idx3){
        if(idx1 < 0 || idx2 < 0 || idx3 < 0) return 0;

        if(dp[idx1][idx2][idx3] != -1) return dp[idx1][idx2][idx3];
        if(s1[idx1] == s2[idx2] && s2[idx2] == s3[idx3]){
            dp[idx1][idx2][idx3] = search(idx1 - 1, idx2 - 1, idx3 - 1) + 1;
        }
        else dp[idx1][idx2][idx3] = Math.max(Math.max(Math.max(search(idx1, idx2, idx3 - 1), search(idx1, idx2 - 1, idx3 - 1)),
                Math.max(search(idx1 - 1, idx2 - 1, idx3), search(idx1 - 1, idx2, idx3 - 1))),
                Math.max(search(idx1 - 1, idx2, idx3), search(idx1, idx2 - 1, idx3)));
        return dp[idx1][idx2][idx3];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();
        s3 = br.readLine().toCharArray();

        len1 = s1.length;
        len2 = s2.length;
        len3 = s3.length;
        dp = new int[len1][len2][len3];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        search(len1 - 1, len2 - 1, len3 - 1);
        System.out.println(search(len1 - 1, len2 - 1, len3 - 1));
    }
}