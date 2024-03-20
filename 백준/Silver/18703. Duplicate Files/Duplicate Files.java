import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Map<String, Integer> map;
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
            List<String> list = new ArrayList<>(map.keySet());
            list.sort(Comparator.comparingInt(map::get));

            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(map.get(list.get(i))).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
