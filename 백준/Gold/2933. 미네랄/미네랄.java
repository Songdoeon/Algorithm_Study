
import java.util.*;
import java.io.*;

class Pos{
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, K;
    static char[][] map;
    static Queue<Pos> queue = new ArrayDeque<>();

    static void fall(){
        boolean[][] visited = new boolean[N][M];

        // 땅에 붙은 녀석들
        for (int i = 0; i < M; i++) {
            if(map[N - 1][i] == 'x' && !visited[N - 1][i]){
                queue.offer(new Pos(N - 1, i));
                visited[N - 1][i] = true;
                while (!queue.isEmpty()){
                    Pos p = queue.poll();

                    for (int d = 0; d < 4; d++) {
                        int nx = p.x + dx[d];
                        int ny = p.y + dy[d];
                        if(outOfMap(nx, ny)) continue;
                        if(map[nx][ny] != 'x')continue;
                        if(visited[nx][ny])continue;
                        visited[nx][ny] = true;
                        queue.offer(new Pos(nx, ny));
                    }
                }
            }
        }

        // 클러스터 만들기
        List<Pos> cluster = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'x' && !visited[i][j]){

                    visited[i][j] = true;
                    cluster.add(new Pos(i, j));
                    queue.offer(new Pos(i, j));

                    while (queue.isEmpty()){
                        Pos p = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = p.x + dx[d];
                            int ny = p.y + dy[d];
                            if(outOfMap(nx, ny)) continue;
                            if(visited[nx][ny])continue;
                            if(map[nx][ny] != 'x')continue;
                            visited[nx][ny] = true;
                            cluster.add(new Pos(i, j));
                            queue.offer(new Pos(nx, ny));
                        }
                    }
                }
            }
        }
        if(cluster.isEmpty()) return ;
//        System.out.println("size = " + cluster.size());
        Map<Integer, Integer> floor = new HashMap<>();
        for (Pos pos : cluster) {
            floor.put(pos.y , Math.max(floor.getOrDefault(pos.y, 0), pos.x));
        }

        boolean find = false;
        int dis = 0;
        // 움직일 수 있는 거리 측정 들어간다.
        while (!find){
            dis++;
            List<Integer> candidates = new ArrayList<>(floor.keySet());
            for (Integer candidate : candidates) {
                int nx = floor.get(candidate) + dis;
                int ny = candidate;
//                System.out.println(nx + " : " + ny + " = " + dis);
                if(outOfMap(nx, ny) || map[nx][ny] == 'x'){
                    find = true;
                    dis--;
                    break;
                }
            }
        }
        cluster.sort((o1, o2) -> o1.x == o2.x ? o1.y - o2.y : o2.x - o1.x);
//        System.out.println("dis " + dis);
        for (Pos pos : cluster) {
            map[pos.x][pos.y] = '.';
//            System.out.println(pos.x + " : " + pos.y);
            map[pos.x + dis][pos.y] = 'x';
//            System.out.println((pos.x + dis) + " : " + pos.y);
        }
    }
    static void broken(int x, boolean isLeft){
        if(isLeft){
            for (int i = 0; i < M; i++) {
                if(map[x][i] == 'x'){
                    map[x][i] = '.';
                    break;
                }
            }
        }
        else{
            for (int i = M - 1; i >= 0; i--) {
//                System.out.println(i);
                if(map[x][i] == 'x'){
                    map[x][i] = '.';
                    break;
                }
            }
        }
//        System.out.println("-=-- break");
//        for (char[] chars : map) {
//            System.out.println(Arrays.toString(chars));
//        }
    }
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        boolean isLeft = true;
        while (K-- > 0){
            int high = N - Integer.parseInt(st.nextToken());
            broken(high, isLeft);
            isLeft = !isLeft;
            fall();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}