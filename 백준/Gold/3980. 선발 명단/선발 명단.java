import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int[][] arr;
    static int ans;
    static boolean[] visited;
    static void search(int idx, int weight){
        if(idx == 11){
            ans = Math.max(ans, weight);
            return ;
        }
        for (int i = 0; i < 11; i++) {
            if(visited[i] || arr[idx][i] == 0)continue;
            visited[i] = true;
            search(idx + 1, weight + arr[idx][i]);
            visited[i] = false;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (T-- > 0){
            arr = new int[11][11];
            visited = new boolean[11];
            ans = 0;
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            search(0, 0);
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
