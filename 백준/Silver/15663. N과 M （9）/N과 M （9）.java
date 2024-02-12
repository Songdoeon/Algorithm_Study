import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[] src, tgt;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder tempSb = new StringBuilder();
    static Set<String> set = new HashSet<>();
    static void search(int depth, int idx){
        if(idx == M){
            tempSb.setLength(0);
            for(int i = 0; i < M; i++){
                tempSb.append(tgt[i]).append(' ');
            }
            if(set.contains(tempSb.toString())) {
                return ;
            }
            set.add(tempSb.toString());
            sb.append(tempSb);
            sb.append('\n');
            return ;
        }

        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            tgt[idx] = src[i];
            search(depth + 1, idx + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        src = new int[N];
        tgt = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            src[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(src);
        search(0, 0);
        System.out.println(sb);
    }
}
