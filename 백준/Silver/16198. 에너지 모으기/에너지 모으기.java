import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16198

public class Main {
    static int N, M;
    static int[] arr;
    static int ans = 0;
    static boolean[] visited;

    static void search(int depth, int total){
        if(depth == M) {
            ans = Math.max(ans, total);
            return ;
        }

        for (int i = 1; i < N - 1; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            int l = i - 1;
            int r = i + 1;
            while (visited[l])l--;
            while (visited[r])r++;
            search(depth + 1, total + arr[l] * arr[r]);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = N - 2;
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        search(0, 0);

        System.out.println(ans);
    }
}
