import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 10775 15:16 시작

class Main{
    static int N, M;
    static int[] arr;
    static int[] parent;
    static int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
    static void union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 < p2) parent[p2] = p1;
        else parent[p1] = p2;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        int ans = 0;
        for(int i = 1; i <= M; i++) {
            int n = Integer.parseInt(br.readLine());
            int p = find(n);
            if(p != 0 && p <= n){
                union(p - 1, n);
                ans++;
            }else break;
        }
        System.out.println(ans);
    }
}