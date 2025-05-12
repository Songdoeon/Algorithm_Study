import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int T, N, M;
    static int[] parents;
    static int[] enemy;
    static int find(int n){
        if(parents[n] == n) return n;
        return parents[n] = find(parents[n]);
    }

    static boolean union(int n1, int n2){
        int p1 = find(n1), p2 = find(n2);
        if(p1 == p2) return false;
        if(p1 > p2){
            parents[p1] = p2;
        }
        else parents[p2] = p1;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(st.nextToken());

        while (T-- > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parents = new int[N + 1];
            enemy = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parents[i] = i;
            }
            boolean find = false;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                if(enemy[n1] == 0){
                    enemy[n1] = n2;
                }
                if(enemy[n2] == 0){
                    enemy[n2] = n1;
                }
                union(n1, enemy[n2]);
                union(n2, enemy[n1]);
                if(find(n1) == find(n2)){
                    find = true;
                }
            }
            if(find)sb.append("impossible").append('\n');
            else sb.append("possible").append('\n');
        }
        System.out.println(sb);
    }
}
