import java.io.*;
import java.util.*;

class Mos{
    int start, end;

    public Mos(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        N = in.nextInt();
        Mos[] arr = new Mos[N];
        int[] starts = new int[N];
        int[] ends = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Mos(in.nextInt(), in.nextInt());
            starts[i] = arr[i].start;
            ends[i] = arr[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);
        int idx = 0;
        
        int max = ends[N - 1];
        int ans = 0;
        int ret = 0;
        int s = 0;
        int e = 0;
        for (int i = 0; i < N; i++) {
            ret++;
            while (idx < max && starts[i] >= ends[idx]) {
                idx++;
                ret--;
            }
            if(ans == ret && starts[i] == e){
                e = ends[idx];
            }
            else if (ans < ret){
                e = ends[idx];
                s = starts[i];
                ans = ret;
            }
        }
        System.out.println(ans + " \n" + s + " " + e);
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