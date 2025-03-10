import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[] arr;
    static int min = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if(Integer.parseInt(st.nextToken()) == 1) {
                if(min == 0) min = i;
                arr[i] = true;
            }
        }
        int max = N;
        boolean[] visited;
        boolean find;
        int mid;
        int ans = max - 1;
        while(min < max){
            find = false;
            Queue<int[]> queue = new ArrayDeque<>();
            mid = (min + max) / 2;
            queue.add(new int[] {N - 1, 0});
            visited = new boolean[N];
//            System.out.println("min = " + min + " max = " + max);
//            System.out.println("mid = " + mid + " ans = " + ans);
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
//                System.out.println(cur[0] + " " + cur[1]);
                if(cur[0] <= 0){
                    find = true;
                    max = Math.min(ans, mid);
                    break;
                }
                if(cur[1] >= K || cur[0] >= N) continue;
                if(visited[cur[0]]) continue;
                visited[cur[0]] = true;
                if(arr[cur[0]])queue.add(new int[] {cur[0] - mid, cur[1] + 1});
                queue.add(new int[] {cur[0] + 1, cur[1]});
            }
            if(!find) {
                min = mid + 1;
            }
            else max = mid;
//            System.out.println("----");
        }
        System.out.println(min);
    }
}
