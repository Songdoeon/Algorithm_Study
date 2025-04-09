import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 12893 12:09 시작

class Main{
    static int N, M;
    static int[] parent;
    static int[] enermy;

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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        enermy = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            if(find(s) == find(t)) {
                System.out.println(0);
                return ;
            }
            if(enermy[s] == 0){
                enermy[s] = t;
            }else{
                union(enermy[s], t);
            }
            if(enermy[t] == 0){
                enermy[t] = s;
            }
            else{
                union(enermy[t], s);
            }
        }

        System.out.println(1);
    }
}