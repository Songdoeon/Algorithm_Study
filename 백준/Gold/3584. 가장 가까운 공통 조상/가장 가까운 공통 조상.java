import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3584 - 08:15 시작

public class Main {
    static int T, N;
    static int[] arr;
    static boolean[] visited;

    static int search(int n1, int n2){
        while (arr[n1] != 0) {
            visited[n1] = true;
            n1 = arr[n1];
        }
        while (arr[n2] != 0) {
            if(visited[n2]) return n2;
            n2 = arr[n2];
        }
        return n1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        while (T-- > 0){
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visited = new boolean[N + 1];
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int root = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                arr[child] = root;
            }

            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            sb.append(search(n1, n2)).append('\n');
        }

        System.out.println(sb);
    }
}

