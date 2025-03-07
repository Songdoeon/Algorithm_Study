import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static int[] arr;
    static boolean[] cnt, visited;
    static void search(int num, int target){
//        System.out.println(arr[num] + " : " + target);

        if(!cnt[arr[num]]) {
            cnt[arr[num]] = true;
            search(arr[num], target);
            cnt[arr[num]] = false;
        }
        if(arr[num] == target) {
            ans++;
            visited[target] = true;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        cnt = new boolean[N + 1];
        visited = new boolean[N + 1];
        ans = 0;
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            cnt[i] = true;
            search(i, i);
            cnt[i] = false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if(visited[i])sb.append(i).append('\n');
        }
        System.out.println(ans + "\n" + sb);
    }
}
