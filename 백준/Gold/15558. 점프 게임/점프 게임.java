import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 15558 : 17:45 시작

public class Main {
    static int N, K;
    static char[][] map;
    static int[] dx;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dx = new int[] {1, -1, K};

        map = new char[2][N];
        map[0] = br.readLine().toCharArray();
        map[1] = br.readLine().toCharArray();

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[N][2];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int idx = cur[0];
            int time = cur[1];
            int flag = cur[2];
            for (int i = 0; i < 3; i++) {
                int nx = idx + dx[i];
                int ny = i == 2 ? (flag + 1) % 2 : flag;
                if(nx >= N) {
                    System.out.println(1);
                    return ;
                }
                if(nx <= time || visited[nx][ny] || map[ny][nx] == '0')continue;
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, time + 1, ny});
            }
        }
        System.out.println(0);
    }
}

