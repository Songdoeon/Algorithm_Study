import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        BitSet bitSet = new BitSet(2_001);
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            bitSet.set(Integer.parseInt(st.nextToken()) + 1000);
        }
        for (int i = 0; i < 2001; i++) {
            if (bitSet.get(i)) sb.append(i - 1000).append(' ');
        }
        System.out.println(sb);
    }
}
