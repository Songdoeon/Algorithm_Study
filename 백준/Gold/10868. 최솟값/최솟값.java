import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        tree = new int[N * 4];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(0, N - 1, 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            sb.append(search(0, N - 1, 1, x, y)).append('\n');
        }
        System.out.println(sb);
    }

    private static int search(int s, int e, int node, int x, int y) {
        if(e < x || y < s) return Integer.MAX_VALUE;

        if(x <= s && e <= y) return tree[node];

        int mid = (s + e) / 2;

        return Math.min(search(s, mid, node * 2, x, y), search(mid + 1, e, node * 2 + 1, x, y));
    }

    private static int init(int s, int e, int node) {
        if(s == e) return tree[node] = arr[s];

        int mid = (s + e) / 2;

        return tree[node] = Math.min(init(s, mid, node * 2), init(mid + 1, e, node * 2 + 1));
    }
}