import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] visited = new int[100_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 1;
        int e = 0;
        long ans = 0;
        while (s <= N){
            while(e + 1 <= N && visited[arr[e + 1]] == 0){
                visited[arr[++e]]++;
            }
            ans += e - s + 1;
            visited[arr[s++]]--;
        }
        System.out.println(ans);
    }
}
