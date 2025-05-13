import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[] parents;
    static int[] arr;

    static int find(int n){
        if(parents[n] == n) return n;
        return parents[n] = find(parents[n]);
    }

    static void union(int n1, int n2){
        int p1 = find(n1), p2 = find(n2);
        if(p1 != p2){
            if(arr[p1] < arr[p2]) parents[p2] = p1;
            else parents[p1] = p2;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        parents = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=  N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            parents[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            union(n1, n2);
        }
        int ans = 0;
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            int p = find(i);
            if(!visited[p]){
                visited[p] = true;
                ans += arr[p];
            }
        }
        System.out.println(ans > K ? "Oh no" : ans);
    }
}
