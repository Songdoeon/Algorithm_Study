import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] elements;
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        elements = new int[N];
        for (int i = 0; i < N; i++) {
            elements[i] = Integer.parseInt(br.readLine());
        }

        int size = getSize();

        tree = new int[size][2];

        initMax(0, N - 1, 1);
        initMin(0, N - 1, 1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            int min = searchMin(0, N - 1, 1, x, y);
            int max = searchMax(0, N - 1, 1, x, y);
            sb.append(min).append(' ').append(max).append('\n');
        }


        System.out.println(sb);
    }

    private static int searchMax(int s, int e, int node, int l, int r) {
        if(e < l || r < s) return Integer.MIN_VALUE;

        if(l <= s && e <= r){
            return tree[node][1];
        }

        int mid = (s + e) / 2;
        return Math.max(searchMax(s, mid, node * 2, l, r), searchMax(mid + 1, e, node * 2 + 1, l, r));
    }

    private static int searchMin(int s, int e, int node, int l, int r) {
        if(e < l || r < s) return Integer.MAX_VALUE;

        if(l <= s && e <= r){
            return tree[node][0];
        }

        int mid = (s + e) / 2;
        return Math.min(searchMin(s, mid, node * 2, l, r), searchMin(mid + 1, e, node * 2 + 1, l, r));
    }


    private static int initMax(int s, int e, int node) {
        if(s == e) return tree[node][1] = elements[s];
        int mid = (s + e) / 2;
        return tree[node][1] = Math.max(initMax(s, mid, node * 2), initMax(mid + 1, e, node * 2 + 1));
    }
    private static int initMin(int s, int e, int node) {
        if(s == e) return tree[node][0] = elements[s];
        int mid = (s + e) / 2;
        return tree[node][0] = Math.min(initMin(s, mid, node * 2), initMin(mid + 1, e, node * 2 + 1));
    }
    private static int getSize() {
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        return (int) Math.pow(2, h + 1);
    }

}