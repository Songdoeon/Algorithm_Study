import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// 2610 : 09:25 시작

public class Main {
    static int N, M, maxDis, dis;
    static int[] parents;
    static List<Integer>[] graph;
    static boolean[] visited;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 > p2){
            parents[p1] = p2;
        }
        else {
            parents[p2] = p1;
        }
    }
    static void search(int idx){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{idx, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            dis = Math.max(dis, cur[1]);
            for(int next : graph[cur[0]]){
                if(visited[next]) continue;
                visited[next] = true;
                q.add(new int[]{next, cur[1] + 1});
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parents = new int[N + 1];
        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
            union(x, y);
        }

        for (int i = 1; i <= N; i++) {
            int p = find(i);
            if(map.containsKey(p)){
                map.get(p).add(i);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(p, list);
            }
        }
        int size = map.keySet().size();

        int[] ans = new int[size];
        Arrays.fill(ans, N + 1);
        int idx = 0;
        for(int component : map.keySet()){
            List<Integer> list = map.get(component);
            maxDis = N + 1;
            for(int n : list){
                dis = 0;
                visited = new boolean[N + 1];
                visited[n] = true;
                search(n);
                if(dis == maxDis && n < ans[idx]){
                    ans[idx] = n;
                }
                else if(dis < maxDis) {
                    ans[idx] = n;
                    maxDis = dis;
                }
            }
            idx++;
        }

        Arrays.sort(ans);
        StringBuilder sb = new StringBuilder();
        sb.append(size).append('\n');

        for (int i = 0; i < size; i++) {
            sb.append(ans[i]).append('\n');
        }
        System.out.println(sb);
    }
}
