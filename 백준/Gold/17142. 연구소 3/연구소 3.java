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
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] map;
    static int[][] tempMap;
    static int[] tgt;
    static List<Pos> virusList;
    static int size;
    static int ans = 100_000;
    static int wall, safe, virus;
    static Queue<Pos> queue = new ArrayDeque<>();
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= N;
    }
    static void backToMap(){
        for (int i = 0; i < N; i++) {
            tempMap[i] = Arrays.copyOfRange(map[i], 0, N);
        }
    }
    static void check(){

        backToMap();
        Pos v;
        visited = new boolean[N][N];
        int tempSafe = safe;
        int depth = 0;
        for (int i = 0; i < M; i++) {
            v = virusList.get(tgt[i]);
            visited[v.x][v.y] = true;
            tempMap[v.x][v.y] = depth;
            queue.offer(v);
        }

        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
//            System.out.println("size : " + size + " : " + depth);
            for (int i = 0; i < size; i++) {
                Pos pos = queue.poll();
//                System.out.println(pos.x + " : " + pos.y + " = " +tempMap[pos.x][pos.y]);
                for (int d = 0; d < 4; d++) {
                    int nx = pos.x + dx[d];
                    int ny = pos.y + dy[d];
                    if(outOfMap(nx, ny) || visited[nx][ny]) continue;
                    if(tempMap[nx][ny] == 1) continue;
                    visited[nx][ny] = true;
                    if(tempMap[nx][ny] == 0) tempSafe--;
                    tempMap[nx][ny] = 2;
                    queue.offer(new Pos(nx, ny));
                }

            }
            if(tempSafe <= 0) break;
        }
//        System.out.println("-----------------------");
//        for (int[] ints : tempMap) {
//            System.out.println(Arrays.toString(ints));
//        }
//        System.out.println(depth);
//        if(depth ==3) System.out.println("1212");
        queue.clear();
        if(tempSafe <= 0) ans = Math.min(ans, depth);

    }
    static void search(int depth, int tgtIdx){
        if(tgtIdx == M){
            check();
            return ;
        }

        for (int i = depth; i < size; i++) {
            tgt[tgtIdx] = i;
            search(i + 1, tgtIdx + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tgt = new int[M];
        wall = 0;
        safe = 0;
        virus = 0;
        visited = new boolean[N][N];
        map = new int[N][N];
        tempMap = new int[N][N];
        virusList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                tempMap[i][j] = n;
                if(map[i][j] == 1) {
                    wall++;
//                    map[i][j] = 9;
//                    tempMap[i][j] = 9;
                }
                else if(map[i][j] == 0) {
//                    map[i][j] = -1;
//                    tempMap[i][j] = -1;
                    safe++;
                }
                else if(map[i][j] == 2){
                    virus++;
                    virusList.add(new Pos(i, j));
                }
            }
        }
        size = virusList.size();
        if(safe == 0){
            System.out.println(0);
            return ;
        }
        search(0, 0);

        System.out.println(ans == 100_000 ? -1 : ans);
    }
}