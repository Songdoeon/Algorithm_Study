import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, P;
    static String X;
    static int answer = 0;
    static boolean[] visited;
    static int[][] info = {
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
    };
    static void search(int depth, int sum, int floor){
        if(depth == K){
            if(floor > 0 && floor <= N) {
                if(!visited[floor])answer++;
                visited[floor] = true;
            }
            return ;
        }

        int num = String.valueOf(X).charAt(depth) - '0';
        for (int i = 0; i < 10; i++) {
            if(sum + info[num][i] > P) continue;
            search(depth + 1, sum + info[num][i], floor * 10 + i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = st.nextToken();
        int len = X.length();
        visited = new boolean[1_000_001];
        visited[Integer.parseInt(X)] = true;
        StringBuilder sb = new StringBuilder();
        for(int i = K; i > len; i--){
            sb.append("0");
        }
        X = sb + X;
        search(0, 0, 0);
        System.out.println(answer);
    }
}