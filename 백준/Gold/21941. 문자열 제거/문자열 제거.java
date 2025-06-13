import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 21941

public class Main {
    static String s;
    static int N;
    static String[] strArr;
    static int[] valueArr;
    static int[] dp;
    static int len;
    static int search(int idx){
        if(idx == 0) return 0;
        if(dp[idx] != -1) return dp[idx];

        int ret = search(idx - 1) + 1;

        for(int i = 0; i < N; i++){
            int len = strArr[i].length();
            if(idx >= len && s.regionMatches(idx - len, strArr[i], 0, len)) {
                ret = Math.max(ret, search(idx - len) + valueArr[i]);
            }
        }

        return dp[idx] = ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        N = Integer.parseInt(br.readLine());
        strArr = new String[N];
        valueArr = new int[N];
        len = s.length();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            strArr[i] = st.nextToken();
            valueArr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[len + 1];
        Arrays.fill(dp, -1);
        System.out.println(search(len));
    }
}
