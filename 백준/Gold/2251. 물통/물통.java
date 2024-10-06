import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int A, B, C;
    static boolean[][][] visited;
    static int[] cnt;
    static void find(int a, int b, int c){
        if(visited[a][b][c]) return;
        visited[a][b][c] = true;
        if(a == 0) cnt[c]++;

        if(a+b <= B) find(0, a+b, c);
        else find((a+b)-B, B, c);

        if(a+c <= C) find(0, b, a+c);
        else find((a+c)-C, b, C);

        if(b+a <= A) find(b+a, 0, c);
        else find(A, (b+a)-A, c);

        if(b+c <= C) find(a, 0, b+c);
        else find(a, (b+c)-C, C);

        if(c+a <= A) find(c+a, b, 0);
        else find(A, b, (c+a)-A);

        if(c+b <= B) find(a, c+b, 0);
        else find(a, B, (c+b)-B);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> pq = new TreeSet<>();
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cnt = new int[C + 1];
        visited = new boolean[A + 1][B + 1][C + 1];
        find(0, 0, C);
        for (int i = 0; i <= C; i++) {
            if(cnt[i] != 0) sb.append(i).append(' ');
        }
        System.out.println(sb);

    }
}