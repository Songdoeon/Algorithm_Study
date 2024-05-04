import java.util.*;
import java.io.*;


class Main {
    static Long N;

    static long getIdx(long n){
        if(n == 0) return 0;
        return (n * (n + 1)) / 2;
    }
    static long calc(long n){
        return 6 * getIdx(n) + 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        if(N == 1){
            System.out.println(1);
            return ;
        }

        long start = 1;
        long end = 1_753_567_890L;
        while (start < end){
            long mid = (start + end) / 2;
            if(calc(mid) < N) {
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        System.out.println(end + 1);
    }
}
