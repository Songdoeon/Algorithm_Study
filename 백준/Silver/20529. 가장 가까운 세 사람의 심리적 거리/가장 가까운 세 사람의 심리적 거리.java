import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static int size;
    static String[] arr;
    static String[] tgt = new String[3];
    static boolean[] visited;
    static boolean find = false;
    static int ans;

    static int distance(String[] strings) {
        int distance = 0;
        for (int i = 0; i < 4; i++) {
            distance += strings[0].charAt(i) != strings[1].charAt(i) ? 1 : 0;
            distance += strings[1].charAt(i) != strings[2].charAt(i) ? 1 : 0;
            distance += strings[0].charAt(i) != strings[2].charAt(i) ? 1 : 0;
        }
        return distance;
    }
    static void search(int depth, int idx){
        if(find) return ;
        if(depth == 3){
            ans = Math.min(ans, distance(tgt));
            if(ans == 0) find = true;
            return ;
        }
        for (int i = idx; i < N; i++) {
            tgt[depth] = arr[i];
            search(depth + 1, i + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while (T --> 0){
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            if(N > 32) {
                sb.append(0).append('\n');
                continue;
            }
            arr = new String[N];
            visited = new boolean[N];
            ans = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                arr[i] = st.nextToken();
            }
            find = false;
            search(0, 0);
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}