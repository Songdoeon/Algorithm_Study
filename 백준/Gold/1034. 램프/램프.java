import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 1034 16:18 시작!
class Main{
    static int N, M;
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int K = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String s = list.get(i);
            int need = s.replace("1","").length();
            if((need <= K) && ((need % 2) == (K % 2))) {
                System.out.println(map.get(s));
                return ;
            }
        }
        System.out.println(0);
    }
}