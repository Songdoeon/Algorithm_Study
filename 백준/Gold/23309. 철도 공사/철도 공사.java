import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] next, prev;

    static int BN(int x, int y) {
        int r = next[x];
        next[x] = y;
        prev[y] = x;
        next[y] = r;
        prev[r] = y;
        return r;
    }

    static int BP(int x, int y) {
        int l = prev[x];
        next[l] = y;
        prev[y] = l;
        next[y] = x;
        prev[x] = y;
        return l;
    }

    static int CN(int x) {
        int r = next[x];
        int rr = next[r];
        next[x] = rr;
        prev[rr] = x;
        return r;
    }

    static int CP(int x) {
        int l = prev[x];
        int ll = prev[l];
        next[ll] = x;
        prev[x] = ll;
        return l;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        next = new int[1_000_002];
        prev = new int[1_000_002];

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            int u = arr[i];
            int v = arr[(i + 1) % N];
            next[u] = v;
            prev[v] = u;
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x = Integer.parseInt(st.nextToken());

            if (cmd.equals("BN")) sb.append(BN(x, Integer.parseInt(st.nextToken())));
            else if (cmd.equals("BP")) sb.append(BP(x, Integer.parseInt(st.nextToken())));
            else if (cmd.equals("CN")) sb.append(CN(x));
            else sb.append(CP(x));
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
