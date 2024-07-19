import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static String[] arr;
    static int[] parents;
    static int[] friends;
    static StringBuilder sb = new StringBuilder();
    static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    static void union(int x, int y){
        int p1 = find(x);
        int p2 = find(y);
        if(p1 != p2){
            parents[p1] = p2;
            friends[p2] += friends[p1];
        }
        sb.append(friends[p2]).append('\n');
    }
    static void set(){
        int n = 2 * N;
        parents = new int[n];
        friends = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        Arrays.fill(friends, 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0){
            N = Integer.parseInt(br.readLine());
            friends = new int[N];
            set();
            int idx = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();
                if(!map.containsKey(name1)) {
                    map.put(name1, idx++);
                }
                if(!map.containsKey(name2)) map.put(name2, idx++);
                int idx1 = map.get(name1);
                int idx2 = map.get(name2);
                union(idx1, idx2);
            }

        }
        System.out.println(sb);
    }
}