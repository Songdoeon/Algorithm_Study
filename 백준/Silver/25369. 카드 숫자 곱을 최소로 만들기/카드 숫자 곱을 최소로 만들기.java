import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] tgt;
    static int sum;
    static StringBuilder sb = new StringBuilder();
    static void search(int idx, int total){
        if(idx == N){
            if(sum >= total) return ;
            for (int i : tgt) {
                sb.append(i).append(' ');
            }
            System.out.println(sb);
            System.exit(0);
        }
        if(Math.pow(9, (N - idx)) * total < sum) return ;
        for (int i = 1; i <= 9; i++) {
            tgt[idx] = i;
            search( idx + 1, total * i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        tgt = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        sum = 1;
        for (int i = 0; i < N; i++) {
            sum *= Integer.parseInt(st.nextToken());
        }

        if(Math.pow(9, N) == sum) {
            System.out.println(-1);
            return ;
        }
        search(0, 1);
    }
}
