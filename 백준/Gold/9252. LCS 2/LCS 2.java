import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 14:25 시작
class Main{
    static char[] s1, s2;
    static int len1, len2;
    static int[][] dp;
    static int ans1 = 0;
    static int s1Idx, s2Idx;
    static int search(int idx1, int idx2){
        if(idx1 < 0 || idx2 < 0) return 0;

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        if(s1[idx1] == s2[idx2]){
            dp[idx1][idx2] = search(idx1 - 1, idx2 - 1) + 1;
            if(ans1 <= dp[idx1][idx2]){
                ans1 = dp[idx1][idx2];
                s1Idx = idx1;
                s2Idx = idx2;
            }
        }
        else dp[idx1][idx2] = Math.max(search(idx1 - 1, idx2), search(idx1, idx2 - 1));
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
        StringBuilder sb = new StringBuilder();

        search(len1 - 1, len2 - 1);
        if(ans1 == 0){
            System.out.println(ans1);
            return ;
        }
        int sum = ans1;
//        System.out.println(s1Idx + " : " + s2Idx + " = " + sum);
        while (sum > 0) {
            if(s1Idx > 0 && dp[s1Idx - 1][s2Idx] == sum) s1Idx--;
            else if(s2Idx > 0 && dp[s1Idx][s2Idx - 1] == sum) s2Idx--;
            else {
                sb.append(s1[s1Idx]);
//                System.out.println(s1Idx + " : " + s2Idx + " = " + sum);
                sum--;
                s1Idx--;
                s2Idx--;
            }
        }
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
        System.out.println(ans1 + "\n" + sb.reverse());
    }
}