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
    static boolean[] wallVisited;
    static int[][] map;
    static int[][] tempMap;

    static int[] tgt = new int[3];
    static List<Pos> wallList;
    static List<Pos> virusList;
    static int size;
    static int ans = 0;
    static int wall, safe, virus;
    static Queue<Pos> queue = new ArrayDeque<>();
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    static void backToMap(){
        for (int i = 0; i < N; i++) {
            tempMap[i] = Arrays.copyOfRange(map[i], 0, M);
        }
    }
    static void check(){
        backToMap();
        Pos p;
        Pos v;
        visited = new boolean[N][M];
        int tempVirus = virus;

        for (int i = 0; i < 3; i++) {
            p = wallList.get(tgt[i]);
            tempMap[p.x][p.y] = 1;
        }

        for (int i = 0; i < virus; i++) {
            v = virusList.get(i);
            queue.offer(v);
        }

        while (!queue.isEmpty()){
            Pos pos = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = pos.x + dx[d];
                int ny = pos.y + dy[d];

                if(outOfMap(nx, ny) || visited[nx][ny]) continue;
                if(tempMap[nx][ny] != 0) continue;
                visited[nx][ny] = true;
                tempMap[nx][ny] = 2;
                tempVirus++;
                queue.offer(new Pos(nx, ny));
            }
        }

//        System.out.println("-----------------------");
//        System.out.println("N * M == " + (N*M) + " wall = " + wall + " virus : " + tempVirus);
//        for (int[] ints : tempMap) {
//            System.out.println(Arrays.toString(ints));
//        }
        ans = Math.max(ans, N * M - wall - tempVirus);
    }
    static void search(int depth, int tgtIdx){
        if(tgtIdx == 3){
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

        wall = 3;
        safe = 0;
        virus = 0;
        visited = new boolean[N][M];
        map = new int[N][M];
        tempMap = new int[N][M];
        wallList = new ArrayList<>();
        virusList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                tempMap[i][j] = n;
                if(map[i][j] == 0) {
                    wallList.add(new Pos(i, j));
                    safe++;
                }
                else if(map[i][j] == 1) wall++;
                else{
                    visited[i][j] = true;
                    virus++;
                    virusList.add(new Pos(i, j));
                }
            }
        }
        size = wallList.size();
        wallVisited = new boolean[size];
        search(0, 0);

        System.out.println(ans);
    }
}