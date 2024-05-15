import java.util.*;
import java.io.*;

class Road{
    int end;
    int cost;

    public Road(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}
public class Main {
    static int N, M;
    static int[] dp;
    static int INF = 10_002;
    static Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    static void calc(int i){
        if(map.containsKey(i)){
            for(Map.Entry<Integer, Integer> entrySet : map.get(i).entrySet()){
                int end = entrySet.getKey();
                int cost = entrySet.getValue();
                dp[end] = Math.min(dp[end], dp[i] + cost);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[M + 1];
        while (N-- > 0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(end > M) continue;
            if(end - start < cost) continue;
            if(map.containsKey(start)){
                Map<Integer, Integer> temp = map.get(start);
                temp.put(end, Math.min(temp.getOrDefault(end, INF), cost));
                map.put(start, temp);
                continue;
            }
            Map<Integer, Integer> temp = new HashMap<>();
            temp.put(end, cost);
            map.put(start, temp);
        }
        Arrays.fill(dp, INF);
        dp[0] = 0;
        calc(0);
        for (int i = 1; i <= M; i++) {
            if(map.containsKey(i)){
                dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
                for(Map.Entry<Integer, Integer> entrySet : map.get(i).entrySet()){
                    int end = entrySet.getKey();
                    int cost = entrySet.getValue();
//                    System.out.println(i + " : " + end +  " = " + cost);
                    dp[end] = Math.min(dp[end], dp[i] + cost);
//                    System.out.println(dp[end]);
                }
            }
            else dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[M]);
    }
}
