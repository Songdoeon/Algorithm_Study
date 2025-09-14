import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_N = 1_000_000;
    static final int[] arr = new int[MAX_N + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        
        int idx = 1;
        int num = 1;
        while (idx <= MAX_N) {
            if (check(num)) arr[idx++] = num;
            num++;
        }
        
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            int n = Integer.parseInt(line);
            if (n == 0) break;
            sb.append(arr[n]).append('\n');
        }
        System.out.print(sb);
    }

    private static boolean check(int x) {
        int mask = 0;
        while (x > 0) {
            int d = x % 10;
            int bit = 1 << d;
            if ((mask & bit) != 0) return false;
            mask |= bit;
            x /= 10;
        }
        return true;
    }
}
