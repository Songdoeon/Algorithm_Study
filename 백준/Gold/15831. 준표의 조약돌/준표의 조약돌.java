import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int N, B, W;
    static char[] road;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        road = br.readLine().toCharArray();
        dp = new int[2][N + 1];
        int b = 0;
        int w = 0;
        int s = 0;
        int e = 0;
        int ans = 0;
        while (e < N){
            if(b <= B) {
                if(road[e++] == 'W'){
                    w++;
                }
                else{
                    b++;
                }
            }
            else {
                if(road[s++] =='W'){
                    w--;
                }
                else{
                    b--;
                }
            }
            if(w >= W && b <= B){
                ans = Math.max(ans, e - s);
            }
        }
        System.out.println(ans);
    }
}