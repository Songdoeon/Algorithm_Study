import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[] parents;
    static List<Integer>[]  enemy;
    static boolean[] check;
    static int find(int n){
        if(n == parents[n]) return n;
        return parents[n] = find(parents[n]);
    }
    static void union(int n, int m){
        int p1 = find(n);
        int p2 = find(m);
        if(p1 == p2) return ;
        if(p1 > p2) parents[p1] = p2;
        else parents[p2] = p1;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        enemy =  new List[N + 1];
        check = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            enemy[i] = new ArrayList<>();
            parents[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(c == 'F')
                union(n, m);
            else{
                enemy[n].add(m);
                enemy[m].add(n);
            }
        }
        for (int i = 1; i <= N; i++) {
            int n = i;

            for (int e : enemy[i]) {
                for(int eToe : enemy[e]){
                    union(n, eToe);
                }
            }

        }
        int ans = 0;
        for(int i = 1; i <= N; i++){
            int n = find(i);
            if(!check[n]){
                ans++;
                check[n] = true;
            }
        }
        System.out.println(ans);
    }
}