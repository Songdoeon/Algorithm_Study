import java.io.*;
import java.util.*;


class Main {
    static int score, N, P;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr;
        N = Integer.parseInt(st.nextToken());
        score = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        if(N == 0) {
            System.out.println(1);
            return ;
        }
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans = -1;
        int len = Math.max(N - P, 0);
        for (int i = N - 1; i >= len; i--) {
            if(arr[i] <= score){
                ans = N - i;
                break ;
            }
        }
        if(ans == -1){
            if(N < P) System.out.println(N + 1);
            else System.out.println(ans);
        }
        else if(N >= P && arr[N - ans] == arr[len] && score == arr[len]) System.out.println(-1);
        else System.out.println(ans);
    }
}