import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        long result = 2_000_000_000;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ldx = 0;
        int rdx = N - 1;
        int start = 0;
        int end = N - 1;
        while (start < end){
            int sum = arr[start] + arr[end];
            if(sum == 0) {
                ldx = start;
                rdx = end;
                break;
            }
            if(result > Math.abs(sum)){
                ldx = start;
                rdx = end;
                result = Math.abs(sum);
            }
            if(sum > 0)end--;
            else start++;
        }

        System.out.println(arr[ldx] + " " + arr[rdx]);
    }
}