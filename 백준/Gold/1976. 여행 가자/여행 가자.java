import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static List<Integer>[] list;
    static int[] parents;

    static int find(int p){
        if(p == parents[p]) return p;
        return parents[p] = find(parents[p]);
    }

    static boolean union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2) return false;

        if(p1 < p2) parents[p2] = p1;

        else parents[p1] = p2;

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        list = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int type = Integer.parseInt(st.nextToken());
                if(type == 1){
                    union(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = parents[Integer.parseInt(st.nextToken())];
        for (int i = 1; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());
            if(parents[next] != start){
                System.out.println("NO");
                return ;
            }
        }

        System.out.println("YES");
    }
}
