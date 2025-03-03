import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer>[] list;
    static int[] depth;
    static int[] parents;
    static void setTree(int cur, int d, int p){
        depth[cur] = d;		//깊이 저장
        parents[cur] = p;	//부모 노드 저장
        //자식 노드들 탐색
        for(int next : list[cur]){
            if(next == p) continue;
            setTree(next, d+1, cur);
        }
    }
    static int lca(int n1, int n2){
        while (depth[n1] > depth[n2]) {
            n1 = parents[n1];
        }
        while (depth[n2] > depth[n1]){
            n2 = parents[n2];
        }
        while (n1 != n2){
            n1 = parents[n1];
            n2 = parents[n2];
        }
        return n1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        parents = new int[N + 1];
        depth = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
        }
        setTree(1, 0, 0);
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(lca(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append('\n');
        }
        System.out.println(sb);
    }
}
