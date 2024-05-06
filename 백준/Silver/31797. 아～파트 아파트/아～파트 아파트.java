import java.util.*;
import java.io.*;

class Main{
    static int N, M;
    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        N = in.nextInt();
        M = in.nextInt();
        int[] arr = new int[10_001];
        boolean[] isExist = new boolean[10_001];
        for (int i = 1; i <= M; i++) {
            int floor1 = in.nextInt();
            int floor2 = in.nextInt();
            isExist[floor1] = isExist[floor2] = true;
            arr[floor1] = arr[floor2] = i;

        }
        int f = N % (2 * M);
        if(f == 0) f = 2 * M;
        int ans = 0;
        int idx = 1;
        while (ans != f){
            if(isExist[idx++]) ans++;
        }
        System.out.println(arr[idx - 1]);
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