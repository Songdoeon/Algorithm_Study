import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int N = readInt();
        int M = readInt();
        int[] arr1 = new int[N];
        int[] arr2 = new int[M];
        for (int i = 0; i < N; i++) {
            arr1[i] = readInt();
        }
        for (int i = 0; i < M; i++) {
            arr2[i] = readInt();
        }
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < N && idx2 < M) {
            if (arr1[idx1] < arr2[idx2]) {
                sb.append(arr1[idx1++]);
            }
            else {
                sb.append(arr2[idx2++]);
            }
            sb.append(' ');
        }
        while (idx1 < N) {
            sb.append(arr1[idx1++]).append(' ');
        }
        while (idx2 < M) {
            sb.append(arr2[idx2++]).append(' ');
        }
        System.out.println(sb);
    }
    private static int readInt() throws IOException {
        int c, n;
        boolean isNegative = false;
        c = System.in.read();
        if (c == '-') {
            isNegative = true;
            c = System.in.read();
        }
        n = c & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return isNegative ? -n : n;
    }
}
