import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new ArrayDeque<>();
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        int[] linked = new int[N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for(int j = 1; j < cnt; j++) {
                int n = Integer.parseInt(st.nextToken());
                graph[prev].add(n);
                linked[n]++;
                prev = n;
            }
        }

        for(int i = 1; i <= N; i++){
            if(linked[i] == 0) queue.offer(i);
        }
        int result = N;
        if(queue.size() == 0){
            System.out.println(0);
            return ;
        }
        while(!queue.isEmpty()){
            int num = queue.poll();
            sb.append(num).append('\n');
            result--;
            for(int n : graph[num]){
                if(--linked[n] == 0) queue.offer(n);
            }
        }
        System.out.println(result == 0 ? sb : 0);
    }
}