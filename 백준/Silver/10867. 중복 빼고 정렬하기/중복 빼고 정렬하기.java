import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int N = read();
        BitSet bitSet = new BitSet(2_001);
        while (N-- > 0) {
            bitSet.set(read() + 1000);
        }
        for (int i = 0; i < 2001; i++) {
            if (bitSet.get(i)) sb.append(i - 1000).append(' ');
        }
        System.out.println(sb);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return negative ? ~n + 1 : n;
    }
}
