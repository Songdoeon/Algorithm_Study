import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] visited = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int cnt = 0;
        int s = 0;
        int e = 0;
        int ans = 0;
        int len = arr.length;
        while(e < len){
            if(visited[arr[e] - 'a']++ == 0){
                cnt++;
            }
            while(cnt > N && s < e){
                if(--visited[arr[s++] - 'a'] == 0) cnt--;
            }
            ans = Math.max(ans, e - s + 1);
            e++;
        }
        System.out.println(ans);
    }
}
