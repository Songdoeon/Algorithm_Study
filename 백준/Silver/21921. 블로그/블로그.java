import java.util.*;
import java.io.*;

class Main{
    static int N, M;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 0; i < M; i++) {
            sum += arr[i];
        }
        map.put(sum, 1);
        int max = sum;
        for (int i = M; i < N; i++) {
            sum -= arr[i - M];
            sum += arr[i];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            max = Math.max(sum, max);
        }
        System.out.println(max == 0 ? "SAD" : max + "\n" + map.get(max));
    }
}