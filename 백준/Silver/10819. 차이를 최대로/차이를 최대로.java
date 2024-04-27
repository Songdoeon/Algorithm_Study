import java.util.*;
import java.io.*;
public class Main{
    static int N, result;
    static int[] arr, ans;
    static boolean[] visited;
    static void search(int cnt){
        if(cnt == N) {
            int sum = 0;
            for(int i = 0; i < N - 1; i++) {
                sum += Math.abs(ans[i] - ans[i + 1]);
            }
            result = Math.max(result, sum);
            return;
        }
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            ans[cnt] = arr[i];
            visited[i] = true;
            search(cnt + 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        ans = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        search(0);
        System.out.println(result);
    }
}