import java.util.*;
import java.io.*;

class Main{
    static int[] arr;
    static int N, M;

    static long check(long mid){
        long n = 0;
        for (int i = 0; i < N; i++) {
            n += arr[i] / mid;
        }
        return n;
    }
    public static void main(String[] args) throws Exception{
        Reader in = new Reader();
        N = in.nextInt();
        M = in.nextInt();
        long sum = 0;
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
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
    static class Reader {
        final int SIZE = 1 << 13;
        byte[] buffer = new byte[SIZE];
        int index, size;

        int nextInt() throws Exception {
            int n = 0;
            byte c;
            while ((c = read()) <= 32);
            do n = (n << 3) + (n << 1) + (c & 15);
            while (isNumber(c = read()));
            return n;
        }

        boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }

        byte read() throws Exception {
            if (index == size) {
                size = System.in.read(buffer, index = 0, SIZE);
                if (size < 0)
                    buffer[0] = -1;
            }
            return buffer[index++];
        }
    }
}
