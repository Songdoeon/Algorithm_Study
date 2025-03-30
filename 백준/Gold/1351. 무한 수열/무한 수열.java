import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 11:51 시작
class Main{
    static long N;
    static int P, Q;
    static Map<Long, Long> map = new HashMap<>();
    static long search(long idx){
        if(map.containsKey(idx)) return map.get(idx);
        long n = search(idx / P) + search(idx / Q);
        map.put(idx, n);
        return n;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        map.put(0L, 1L);
        System.out.println(search(N));
    }
}