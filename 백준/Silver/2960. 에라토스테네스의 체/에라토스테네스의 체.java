import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BitSet set = new BitSet(n);
        for (int i = 2; i <= n; i++) {
            if(set.get(i)) continue;
            for (int j = i; j <= n; j += i) {
                if(set.get(j)) continue;
                set.set(j);
                if (--m == 0) {
                    System.out.print(j);
                    return;
                }
            }
        }
    }
}
