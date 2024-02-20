import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        long result = Long.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long[] ans = new long[3];

        for(int i = 0; i < N - 2; i++){
            int start = i + 1;
            int end = N - 1;

            while(start < end){
                long sum = arr[i] + arr[start] + arr[end];

                if(Math.abs(sum) < result) {
                    result = Math.abs(sum);
                    ans[0] = arr[i];
                    ans[1] = arr[start];
                    ans[2] = arr[end];
                }
                if(sum > 0){
                    end--;
                }
                else start++;
            }
        }
        System.out.print(ans[0] + " " + ans[1] + " " + ans[2]);

    }
}
