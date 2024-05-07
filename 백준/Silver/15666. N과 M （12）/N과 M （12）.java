import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] src, tgt;
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new LinkedHashSet<>();

    static void search(int depth, int idx){
        if(depth == M){
//            Arrays.sort(tgt);
            for (int i = 0; i < M; i++) {
                sb.append(tgt[i]).append(" ");
            }
            set.add(sb.toString());
            sb.setLength(0);
            return ;
        }
        for (int i = idx; i < N; i++) {
            tgt[depth] = src[i];
            search(depth+1, i);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        src = new int[N];
        tgt = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(src);

            search(0, 0);

        for (String s : set) {
            sb.append(s).append('\n');
        }
        System.out.println(sb);
    }
}