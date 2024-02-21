import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    static List<Integer>[] list;
    static boolean[] visited;
    static boolean find = false;
    static void search(int depth, int n){
        if(depth == 4) {
            find = true;
            return ;
        }
        for(int num : list[n]){
            if(visited[num])continue;
            visited[num] = true;
            search(depth + 1, num);
            visited[num] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        list = new ArrayList[N];
        for(int i = 0; i < N; i++){
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }
        for(int i = 0; i < N; i++){
            
            if(find) break;
            visited[i] = true;
            search(0,i);
            visited[i] = false;
        }
        System.out.println(find ? 1 : 0);
    }
}