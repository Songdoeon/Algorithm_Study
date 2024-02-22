import java.io.*;
import java.util.*;

public class Main {
    static int N, min;
    static int[][] map;
    static boolean[] select;    // 부분집합에서 사용
    static boolean[] visited;   // 모두 연결되어있는지 판단 사용

    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        select = new boolean[N + 1];
        visited = new boolean[N + 1];
        min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            map[i][0] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= n; j++) {
                int v = Integer.parseInt(st.nextToken());
                map[i][j] = v;
            }
        }
        subset(1);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }
    static void check(){
        Arrays.fill(visited, false);
        queue.clear();

        for (int i = 1; i <= N; i++) {
            if(select[i]){
                visited[i] = true;
                queue.offer(i);
                break;
            }
        }

        if(queue.isEmpty()) return ;

        while (!queue.isEmpty()){
            int v = queue.poll();

            for(int i = 1; i <= N; i++){
                int adj = map[v][i];
                if(adj != 0 && !visited[adj] && select[adj]){
                    visited[adj] = true;
                    queue.offer(adj);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if(!select[i]){
                visited[i] = true;
                queue.offer(i);
                break;
            }
        }

        if(queue.isEmpty()) return ;

        while (!queue.isEmpty()){
            int v = queue.poll();

            for(int i = 1; i <= N; i++){
                int adj = map[v][i];
                if(adj != 0 && !visited[adj] && !select[adj]){
                    visited[adj] = true;
                    queue.offer(adj);
                }
            }
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]) return;
        }

        int sumA = 0;
        int sumB = 0;

        for(int i = 1; i <= N; i++){
            if(select[i]) sumA += map[i][0];
            else  sumB += map[i][0];
        }

        min = Math.min(min, Math.abs(sumA - sumB));
    }

    static void subset(int srcIdx){
        if(srcIdx == N + 1){
            check();
            return ;
        }

        select[srcIdx] = true;
        subset(srcIdx + 1);
        select[srcIdx] = false;
        subset(srcIdx + 1);
    }
}

