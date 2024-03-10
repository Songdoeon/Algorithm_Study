import java.io.*;
import java.util.*;
public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Map<Integer, Integer>> set = new HashSet<>();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        String op = br.readLine();
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(op.charAt(i) == '+') {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            else {
                map.put(n, map.getOrDefault(n, 0) - 1);
            }
            if(map.get(n) == 0) map.remove(n);
            if(map.size() == 0) break;
            set.add(new HashMap<>(map));
        }
        if(map.size() == 0 || set.size() != M) System.out.println(0);
        else System.out.println(1);
    }
}