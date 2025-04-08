import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 2109 10:57 시작

class Main{
    static int N, M;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            queue.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        int ans = 0;
        boolean[] visited = new boolean[10_001];
        while (!queue.isEmpty()){
            int[] info = queue.poll();
            int pay = info[0];
            int due = info[1];
            for (int i = due; i >= 1; i--) {
                if(visited[i])continue;
                visited[i] = true;
                ans += pay;
                break;
            }
        }
        System.out.println(ans);
    }
}