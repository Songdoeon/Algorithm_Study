import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 33511

public class Main {
    static int[] arr;
    static boolean[][] dp;
    static boolean flag = false;
    static void search(int x, int y, int z){
        if(flag)return ;
        if(dp[x][y]) return ;
        dp[x][y] = true;

        if(x == y && y == z){
            flag = true;
            return ;
        }

        int[] stone = {x, y, z};

        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if(stone[i] < stone[j]){
                    int nx = 2 * stone[i];
                    int ny = stone[j] - stone[i];
                    int nz = stone[3 - i - j];

                    int[] next = {nx, ny, nz};
                    Arrays.sort(next);

                    if(dp[next[0]][next[1]]) continue;
                    search(next[0], next[1], next[2]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[3];
        dp = new boolean[1001][1001];

        for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());

        if((arr[0] + arr[1] + arr[2]) % 3 == 0) {
            Arrays.sort(arr);
            search(arr[0], arr[1], arr[2]);
        }
        System.out.println(flag ? "1" : "0");
    }
}
