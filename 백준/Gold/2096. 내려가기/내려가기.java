import java.util.*;
import java.io.*;

class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int[][] max = new int[N + 1][5];
        int[][] min = new int[N + 1][5];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            min[i][0] = min[i][4] = 900_001;
            for (int j = 1; j <= 3; j++) {
                int n = Integer.parseInt(st.nextToken());
                max[i][j] = Math.max(Math.max(max[i - 1][j],max[i-1][j - 1]), max[i - 1][j + 1]) + n;
                min[i][j] = Math.min(Math.min(min[i - 1][j],min[i-1][j - 1]), min[i - 1][j + 1]) + n;
            }
        }
        int maxN = Math.max(Math.max(max[N][1], max[N][2]), max[N][3]);
        int minN = Math.min(Math.min(min[N][1], min[N][2]), min[N][3]);
        System.out.println(maxN + " " + minN);
    }
}