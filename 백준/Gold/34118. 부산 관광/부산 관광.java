import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 34118

public class Main {
    static int N, p1, p3, p5, pp;
    static char[] arr1, arr2;
    static int[][] dp;
    static int INF = 200_000_001;

    static int next1(int i){
        while(i < N && arr1[i] == '0') i++; return i;
    }

    static int next2(int j){
        while(j < N && arr2[j] == '0') j++; return j;
    }

    static int search(int idx1, int idx2){
        idx1 = next1(idx1);
        idx2 = next2(idx2);
        if (idx1 >= N && idx2 >= N) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        int ret = INF;

        int s = Math.min(idx1, idx2);
        int e = s + 4;
        if(idx1 < N || idx2 < N) ret = Math.min(ret , search(e, e) + pp);

        if(idx1 < N){
            ret = Math.min(ret, search(idx1 + 1, idx2) + p1);
            ret = Math.min(ret, search(idx1 + 3, idx2) + p3);
            ret = Math.min(ret, search(idx1 + 5, idx2) + p5);
        }
        if(idx2 < N){
            ret = Math.min(ret, search(idx1, idx2 + 1) + p1);
            ret = Math.min(ret, search(idx1, idx2 + 3) + p3);
            ret = Math.min(ret, search(idx1, idx2 + 5) + p5);
        }

        return dp[idx1][idx2] = ret;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr1 = br.readLine().toCharArray();
        arr2 = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p3 = Integer.parseInt(st.nextToken());
        p5 = Integer.parseInt(st.nextToken());
        pp = Integer.parseInt(st.nextToken());


        dp = new int[N + 6][N + 6];

        for (int i = 0; i < N + 6; i++) Arrays.fill(dp[i], -1);

        System.out.println(search(0, 0));

    }
}