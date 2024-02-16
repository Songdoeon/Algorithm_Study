import java.util.*;
import java.io.*;

class Main{
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int N, M, V;

    static void search(int n){

        for (int next : graph.get(n)){
            if(visited[next]) continue;
            visited[next] = true;
            sb.append(next).append(' ');
            search(next);

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
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(end).add(start);
            graph.get(start).add(end);
        }
        for(int i = 1; i <= N; i++){
            graph.get(i).sort(Comparator.comparingInt(o -> o));
        }

        sb.append(V).append(' ');
        visited[V] = true;
        search(V);
        sb.append('\n');

        Arrays.fill(visited, false);
        visited[V] = true;
        queue.add(V);
        sb.append(V).append(' ');
        while(!queue.isEmpty()){
            int p = queue.poll();

            for(int next : graph.get(p)){
                if(visited[next]) continue;
                visited[next] = true;
                queue.add(next);
                sb.append(next).append(' ');
            }
        }
        System.out.println(sb);
    }
}