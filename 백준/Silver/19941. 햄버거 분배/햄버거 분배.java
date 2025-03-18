import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static char[] arr;
    static boolean[] visited;
    static boolean check(int i){

        for (int j = -K; j <= K; j++) {
            if(j == 0) continue;
            if(i + j < 0 || i + j >= N) continue;
            if(visited[i + j]) continue;
            if(arr[i + j] !=  'H') continue;
            visited[i + j] = true;
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = br.readLine().toCharArray();
        visited = new boolean[N];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i] == 'H') continue;
            if(check(i)){
                answer++;
            }
        }
        System.out.println(answer);
    }
}