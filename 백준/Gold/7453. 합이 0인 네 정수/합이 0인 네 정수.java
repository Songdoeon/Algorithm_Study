import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[] sum1, sum2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[4][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        long ans = 0;
        sum1 = new int[N * N];
        sum2 = new int[N * N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum1[idx] = arr[0][i] + arr[1][j];
                sum2[idx++] = arr[2][i] + arr[3][j];
            }
        }

        Arrays.sort(sum1);
        Arrays.sort(sum2);
        int max = N * N;
        int idx1 = 0;
        int idx2 = max - 1;
//        System.out.println(Arrays.toString(sum1));
//        System.out.println(Arrays.toString(sum2));

        while (idx1 < max && idx2 >= 0) {
            int sum = sum1[idx1] + sum2[idx2];
            if (sum == 0) {
                long tempA = 1;
                long tempB = 1;
                while(idx1 < max - 1 && sum1[idx1] == sum1[idx1 + 1]){
                    idx1++;
                    tempA++;
                }
                while(idx2 > 0 && sum2[idx2] == sum2[idx2 - 1]){
                    idx2--;
                    tempB++;
                }
                ans += tempA * tempB;
                idx1++;
                idx2--;
            }
            else if(sum < 0) {
                idx1++;
            }
            else{
                idx2--;
            }
        }
        System.out.println(ans);
    }
}