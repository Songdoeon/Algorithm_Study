import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16198

public class Main {
    static int N;
    static int[] arr;
    static int ans = 0;
    static boolean[] visited;

    static int calc(int idx){
        int ret = 0;

        for (int i = idx - 1; i >= 0; i--) {
            if(!visited[i]) {
                ret = arr[i];
                break;
            }
        }

        for (int i = idx + 1; i < N ; i++) {
            if(!visited[i]) {
                ret *= arr[i];
                break;
            }
        }

        return ret;
    }

    static void search(int depth, int total){
        if(depth == N - 2) {
            ans = Math.max(ans, total);
            return ;
        }

        for (int i = 1; i < N - 1; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            search(depth + 1, total + calc(i));
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        search(0, 0);

        System.out.println(ans);
    }
}
