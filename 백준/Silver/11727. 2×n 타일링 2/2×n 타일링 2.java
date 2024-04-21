import java.io.*;
import java.util.*;

class Main{
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        arr[1] = 1;
        if(N == 1) {
            System.out.println(1);
            return ;
        }
        arr[2] = 3;
        for (int i = 3; i <= N; i++) {
            arr[i] = (arr[i - 2] * 2 + arr[i - 1]) % 10_007;
        }

        System.out.println(arr[N]);
    }
}