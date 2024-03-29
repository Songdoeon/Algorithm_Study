import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pos{
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pos pos = (Pos) o;
        return x == pos.x && y == pos.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
class Edge{
    int x, y, cost;

    public Edge(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}
class Island{
    Set<Pos> list = new HashSet<>();

    public Island() {}

}
public class Main {
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int[] parents;
    static int size;
    static List<Island> list;
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    static int find(int x){
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
    static boolean union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1 == p2) return false;
        if(p1 > p2){
            parents[p2] = p1;
        }
        else{
            parents[p1] = p2;
        }
        return true;
    }
    static int search(Pos pos){
        for (int i = 0; i < size; i++) {
            if(list.get(i).list.contains(pos)) return i;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Queue<Pos> queue = new ArrayDeque<>();
        list = new ArrayList<>();
        visited = new boolean[N][M];
        map = new int[N][M];
        char[] chars;
        for (int i = 0; i < N; i++) {
            chars = br.readLine().replace(" ", "").toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j] - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1 && !visited[i][j]){
                    queue.offer(new Pos (i, j));
                    visited[i][j] = true;
                    Island island = new Island();
                    island.list.add(new Pos (i, j));
                    while (!queue.isEmpty()){
                        Pos pos = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = pos.x + dx[d];
                            int ny = pos.y + dy[d];

                            if(outOfMap(nx, ny)) continue;
                            if(visited[nx][ny]) continue;
                            if(map[nx][ny] != 1) continue;
                            visited[nx][ny] = true;
                            island.list.add(new Pos(nx, ny));
                            queue.offer(new Pos(nx, ny));
                        }
                    }
                    list.add(island);
                }
            }
        }
        size = list.size();
        for (int i = 0; i < size; i++) {
            Set<Pos> set = list.get(i).list;

            for (Pos ints : set) {
                int x = ints.x;
                int y = ints.y;

                for (int d = 0; d < 4; d++) {
                    queue.offer(new Pos (x, y));
                    while (!queue.isEmpty()){
                        Pos pos = queue.poll();
                        int cx = pos.x + dx[d];
                        int cy = pos.y + dy[d];

                        if(outOfMap(cx, cy)) break;
                        if(map[cx][cy] == 1){
                            Pos des = new Pos (cx, cy);
                            if(set.contains(new Pos (cx, cy))) break;
                            int next = search(des);
                            int dis = cx == x ? Math.abs(cy - y) : Math.abs(cx - x);
                            if(dis > 2) {
                                pq.add(new Edge(i, next, --dis));
                            }
                            break;
                        }
                        queue.offer(new Pos (cx, cy));

                    }
                }
            }
        }
        parents = new int[size];
        for (int i = 0; i < size; i++) {
            parents[i] = i;
        }

        int edge = 0;
        int dis = 0;
        while (!pq.isEmpty()){
            Edge e = pq.poll();

            int start = e.x;
            int end = e.y;

            if(union(start, end)){
                dis += e.cost;
                edge++;
            }
        }
        System.out.println(edge != size - 1 ? -1 : dis);
    }
}