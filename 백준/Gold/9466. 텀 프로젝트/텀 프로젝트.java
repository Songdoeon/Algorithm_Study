import java.util.*;
import java.io.*;

class Main{
    static boolean[] visited, selected;
    static int[] arr;
    static int ans;
    static void search(int idx){
        if(selected[idx]) return ;
        if(visited[idx]) {
            selected[idx] = true;
            ans++;
        }
        visited[idx] = true;
        search(arr[idx]);
        selected[idx] = true;
        visited[idx] = false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            ans = 0;
            arr = new int[N + 1];
            visited = new boolean[N + 1];
            selected = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i] = n;
            }
            for (int i = 1; i <= N; i++) {
                if(selected[i]) continue;
                search(i);
            }
            sb.append(N - ans).append('\n');
        }
        System.out.println(sb);
    }
}