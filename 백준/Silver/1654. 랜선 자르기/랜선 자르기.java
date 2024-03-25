import java.util.*;
import java.io.*;

class Main{
    static long[] arr;
    static int N, M;

    static long check(long mid){
        long n = 0;
        for (int i = 0; i < N; i++) {
            n += arr[i] / mid;
        }
        return n;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long sum = 0;
        arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        long min = 0;

        long max = sum / M + 1;
        long answer = 0;
        while(min < max){
            long mid = (min + max) / 2;
            long n = check(mid);
            if(n >= M){
                answer = mid;
                min = mid + 1;
            }
            else{
                max = mid;
            }
        }
        System.out.println(answer);
    }
}
