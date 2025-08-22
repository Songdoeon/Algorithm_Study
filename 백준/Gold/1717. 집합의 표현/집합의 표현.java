import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1715

public class Main {
    static int N, K;
    static int[] parents;

    static int find(int n){
        if(parents[n] == n) return n;
        return parents[n] = find(parents[n]);
    }

    static void union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1 < p2) parents[p2] = p1;
        else parents[p1] = p2;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) parents[i] = i;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int exec = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(exec == 0) union(a, b);
            else {
                if(find(a) == find(b)) sb.append("YES");
                else sb.append("NO");
                sb.append('\n');
            }
        }
        System.out.println(sb);

    }
}