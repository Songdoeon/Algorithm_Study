import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

// 13265

public class Main {
    static int T, N, M;
    static int[] parents;
    static int[] enemy;
    static int find(int n){
        if(parents[n] == n) return n;
        return parents[n] = find(parents[n]);
    }

    static void union(int n1, int n2){
        int p1 = find(n1), p2 = find(n2);
        if(p1 != p2) parents[p1] = p2;
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
                int n1 = find(Integer.parseInt(st.nextToken()));
                int n2 = find(Integer.parseInt(st.nextToken()));
                if(find || n1 == n2) {
                    find = true;
                    continue;
                }

                int e1 = enemy[n1];
                int e2 = enemy[n2];

                if(e1 != 0) union(e1, n2);
                else enemy[n1] = n2;

                if(e2 != 0) union(n1, e2);
                else enemy[n2] = n1;
            }
            sb.append(find ? "impossible" : "possible").append('\n');
        }
        System.out.println(sb);
    }
}
