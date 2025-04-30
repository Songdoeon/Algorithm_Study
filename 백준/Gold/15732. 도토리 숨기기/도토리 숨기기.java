import java.io.*;
import java.util.*;

// 15732 : 16:04 시작

public class Main {
    static int N, K, D;
    static int[] arr;
    static int[][] rule;

    static boolean check(int mid){
        int ret = 0;
        for (int i = 0; i < K; i++) {
            int s = rule[i][0];
            if(mid < s) continue;
            int e = Math.min(rule[i][1], mid);
            ret += (e - s) / rule[i][2] + 1;
            if(ret >= D) return true;
        }
        return ret >= D;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        rule = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int jump = Integer.parseInt(st.nextToken());
            rule[i] = new int[]{s, e, jump};
        }

        int s = 1;
        int e = N + 1;
        while (s < e){
            int mid = (s + e) / 2;
            if(check(mid)){
                e = mid;
            }
            else{
                s = mid + 1;
            }
        }
        System.out.println(e);
    }
}

