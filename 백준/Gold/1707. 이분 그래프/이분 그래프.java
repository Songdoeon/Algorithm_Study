import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 12893 12:09 시작

class Main{
    static int T, N, M;
    static int[] parent;
    static int[] opposite;
    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        int p1 = find(x);
        int p2 = find(y);
        if(p1 < p2) parent[p2] = p1;
        else parent[p1] = p2;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parent = new int[N + 1];
            opposite = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }
            boolean find = true;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(find(x) == find(y)) {
                    find = false;
                }
                if(opposite[x] == 0){
                    opposite[x] = y;
                    if(opposite[y] != 0) {
                        union(x, opposite[y]);
                        continue;
                    }
                }
                if(opposite[y] == 0){
                    opposite[y] = x;
                    if(opposite[x] != 0) {
                        union(opposite[x], y);
                        continue;
                    }
                }
                if(opposite[y] != opposite[x]){
                    union(x, opposite[y]);
                    union(y, opposite[x]);
                }
            }
            if(!find)sb.append("NO").append('\n');
            else sb.append("YES").append('\n');
        }
        System.out.println(sb);
    }
}