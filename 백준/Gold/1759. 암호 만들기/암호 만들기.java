import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[] arr;
    static char[] tgt;
    static StringBuilder sb = new StringBuilder();

    static void search(int depth, int tgtIdx){
        if(tgtIdx == N){
            String str = String.valueOf(tgt);
            if(str.replaceAll("[aeiou]", "").length() < 2) return ;
            if(str.replaceAll("[^aeiou]", "").isEmpty()) return ;
            sb.append(str).append('\n');
            return ;
        }
        for (int i = depth; i < M; i++) {
            tgt[tgtIdx] = arr[i];
            search(i + 1, tgtIdx + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = br.readLine().replace(" ", "").toCharArray();
        tgt = new char[N];
        Arrays.sort(arr);

        search(0, 0);
        System.out.println(sb);
    }
}