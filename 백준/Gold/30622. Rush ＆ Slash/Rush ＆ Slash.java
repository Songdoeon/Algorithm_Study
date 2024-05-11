import java.util.*;
import java.io.*;

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

        if (x != pos.x) return false;
        return y == pos.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
public class Main {
    static int N;
    static int[] parent;
    static Pos[] list;
    static int[] dx = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};
    static Map<Pos, Integer> map = new HashMap<>();
    static int getDis(Pos p) {
        return Math.abs(p.x) + Math.abs(p.y);
    }
    static int find(int n){
        if(parent[n] == n)return n;
        return parent[n] = find(parent[n]);
    }
    static void union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 > p2) parent[p2] = p1;
        else parent[p1] = p2;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new Pos[N];
        parent = new int[N];

        long max = 0;
        long ans = 0;
        Pos temp;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            parent[i] = i;
            Pos p = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int j = 0; j < 8; j++) {
                int nx = p.x + dx[j];
                int ny = p.y + dy[j];
                temp = new Pos(nx, ny);
                if(map.containsKey(temp)){
                    union(i, map.get(temp));
                }
            }
            map.put(p, i);
        }
        Map<Integer, Long> dis = new HashMap<>();
        for (Map.Entry<Pos, Integer> entrySet : map.entrySet()) {
            int index = entrySet.getValue();
            int parent = find(index);
            dis.put(parent, Math.min(getDis(entrySet.getKey()), dis.getOrDefault(parent, 4_000_000_000L)));
        }
        for (Long distance : dis.values()) {
            ans += 2 * distance;
            max = Math.max(distance, max);
        }
        System.out.println(ans - max);
    }
}