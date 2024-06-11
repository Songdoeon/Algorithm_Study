import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Map<String, Integer> map;
        List<Integer> list;
        int max = Integer.MAX_VALUE;
        while (T-- > 0){
            int N = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                if(map.getOrDefault(str, max) > n) map.put(str, n);
            }
            list = new ArrayList<>(map.values());
            Collections.sort(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(list.get(i)).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
