import java.io.*;
import java.util.*;

public class Main {
    static int N, d, k, c, max;
    static int[] tgt;

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();

        N = in.nextInt();
        d = in.nextInt();
        k = in.nextInt();
        c = in.nextInt();
        tgt = new int[k + 1];
        int[] init = new int[k];
        int[] dishes = new int[d + 1];
        int result = 1;
        dishes[c] = 1;
        for (int i = 1; i <= k; i++) {
            int n = in.nextInt();
            if(--dishes[tgt[i % k]] == 0) result--;
            if(dishes[n]++ == 0) result++;
            tgt[i % k] = n;
            init[i - 1] = n;
        }

        max = result;
        for (int i = k + 1; i <= N; i++) {
            int n = in.nextInt();
            if(--dishes[tgt[i % k]] == 0) result--;
            if(dishes[n]++ == 0) result++;
            tgt[i % k] = n;

            max = Math.max(max, result);

        }
        int idx = 0;
        for(int i = N + 1; i <= N + k; i++){
            int n = init[idx++];

            if(--dishes[tgt[i % k]] == 0)result--;
            if(dishes[n]++ == 0) result++;
            tgt[i % k] = n;

            max = Math.max(max, result);
        }
        System.out.println(max);
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
