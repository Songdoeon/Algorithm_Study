import java.util.*;
import java.io.*;

class Main{
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] graph;
    static boolean[] visited;
    static int N, M, V;

    static void search(int n){
        visited[n] = true;
        sb.append(n).append(' ');
        List<Integer> childs = graph[n];
        for(Integer child : childs){
            if(visited[child])continue;
            visited[child] = true;
            search(child);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        graph = new List[N + 1];
        for (int i = 0; i <= N; i++) { // 그래프 생성
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }
        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }
        visited[V] = true;
        search(V);
        sb.append('\n');

        Arrays.fill(visited, false);
        visited[V] = true;
        queue.add(V);
        int p;
        while(!queue.isEmpty()){
            p = queue.poll();
            sb.append(p).append(' ');
            List<Integer> childs = graph[p];
            for(Integer child : childs){
                if(visited[child])continue;
                visited[child] = true;
                queue.offer(child);
            }
        }
        System.out.println(sb);
    }
}