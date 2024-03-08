import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] visited = new int[200_001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        visited[arr[0]]++;
        int cnt = 1;
        int result = 0;
        while (end < N - 1){
            if(++visited[arr[++end]] > M){
                cnt++;
                while(visited[arr[end]] > M){
                    visited[arr[start++]]--;
                    cnt--;
                }
            }
            else{
                cnt++;
                result = Math.max(result,cnt);
            }
        }
        System.out.println(result);
    }
}