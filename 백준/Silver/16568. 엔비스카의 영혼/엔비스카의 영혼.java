import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int N, A, B;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.offer(new int[]{N, 0});
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == 0){
                System.out.println(cur[1]);
                break;
            }
            if(visited[cur[0]])continue;
            visited[cur[0]] = true;
            cur[0]--;
            if(cur[0] >= A){
                queue.offer(new int[]{cur[0] - A, cur[1] + 1});
            }
            if(cur[0] >= B){
                queue.offer(new int[]{cur[0] - B, cur[1] + 1});
            }
            queue.offer(new int[] {cur[0], cur[1] + 1});
        }
    }
}
