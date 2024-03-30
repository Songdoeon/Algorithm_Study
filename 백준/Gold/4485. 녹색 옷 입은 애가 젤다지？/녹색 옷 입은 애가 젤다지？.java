import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int x, y, cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}
public class Main {
    static int[] dx = {1, 0 ,-1, 0};
    static int[] dy = {0 ,1, 0, -1};
    static int T;
    static int[][] map;
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= T || y < 0 || y >= T;
    }
    static int search() {
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        int[][] move = new int[T][T];
        for(int i = 0; i < T; i++) {
            Arrays.fill(move[i], 1200);
        }

        q.add(new Node(0, 0, map[0][0]));
        move[0][0] = map[0][0];

        while(!q.isEmpty()) {
            Node pos = q.poll();
            int px = pos.x;
            int py = pos.y;
            int cost = pos.cost;

            if(px == T-1 && py == T-1) {
                return cost;
            }

            for(int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(outOfMap(nx, ny)) continue;

                if(move[ny][nx] > cost + map[ny][nx]) {
                    move[ny][nx] = cost + map[ny][nx];
                    q.add(new Node(nx, ny, move[ny][nx]));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int idx = 1;
        while(true){
            if((T = Integer.parseInt(br.readLine())) == 0) break;
            map = new int[T][T];
            for (int i = 0; i < T; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < T; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int ans = search();
            sb.append("Problem ").append(idx++).append(": ").append(ans).append('\n');
        }

        System.out.println(sb);
    }
}