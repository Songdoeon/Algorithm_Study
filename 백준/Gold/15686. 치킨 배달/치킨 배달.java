import java.io.*;
import java.util.*;

class Pos{
    int x;
    int y;

    int dis;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N;
    static int M;
    static int ans = 0;
    static List<Pos> chickenList = new ArrayList<>();
    static List<Pos> houseList = new ArrayList<>();
    static int distance(Pos p1, Pos p2){
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 1) houseList.add(new Pos(i, j));
                else if(n == 2) chickenList.add(new Pos(i, j));
            }
        }

        int ans = 10000;
        int size = chickenList.size();
        int cnt = 1 << size;
        for(int mask = 1; mask < cnt; mask++){
            if(Integer.bitCount(mask) != M) continue;
            int total = 0;
            for(Pos house : houseList) {
                int dis;
                int res = 10000;
                for(int j = 0; j < size; j++){
                    if((mask & 1 << j) != 0) {
                        dis = distance(house, chickenList.get(j));
                        res = Math.min(dis, res);
                    }
                }
                if(res != 10000)total += res;
            }
            ans = Math.min(ans, total);
        }
        System.out.println(ans);
    }
}