import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long[] elements, tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        elements = new long[N];

        for (int i = 0; i < N; i++) {
            elements[i] = Long.parseLong(br.readLine());
        }
        int size = getSize();
        tree = new long[size];
        init(0, N - 1, 1);

        StringBuilder sb =  new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int exec = Integer.parseInt(st.nextToken());
            if(exec == 2){
                long x = Long.parseLong(st.nextToken()) - 1;
                long y = Long.parseLong(st.nextToken()) - 1;
                long sum = sum(0, N - 1, 1, x, y);
                sb.append(sum).append('\n');
            }
            else {
                long x = Long.parseLong(st.nextToken()) - 1;
                long y = Long.parseLong(st.nextToken());
                long dif = y - elements[(int) x];
                update(0, N - 1, 1, x, dif);
                elements[(int) x] = y;
            }
        }
        System.out.println(sb);
    }

    private static void update(int s, int e, int node, long idx, long dif) {
        if(s <= idx && idx <= e) tree[node] += dif;
        else return ;

        if(s == e) return ;

        int mid = (s + e) / 2;
        update(s, mid, node * 2, idx, dif);
        update(mid + 1, e, node * 2 + 1, idx, dif);
    }

    private static long sum(int s, int e, int node, long l, long r) {
        if(e < l || r < s) return 0;
        if(l <= s && e <= r) return tree[node];

        int mid = (s + e) / 2;
        return sum(s, mid, node * 2, l, r) + sum(mid + 1, e, node * 2 + 1, l, r);
    }


    private static long init(int s, int e, int node) {
        if(s == e) return tree[node] = elements[s];
        int mid = (s + e) / 2;
        return tree[node] = init(s, mid, node * 2) + init(mid + 1, e, node * 2 + 1);
    }

    private static int getSize() {
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        return (int) Math.pow(2, h + 1);
    }

}