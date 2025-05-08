import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 실버부수기

public class Main {
    static int T, N, M;
    static boolean[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= T; i++) {
            queue.addLast(i);
        }
        int ans = 1;
        int size = 0;
        while ((size = queue.size()) != 1) {

            int win = 0;
            if(size % 2 != 0){
                win = queue.pollLast();
                size--;
            }
            size /= 2;
            for (int i = 0; i < size; i++) {
                int n = queue.removeFirst();
                int m = queue.removeFirst();
                if((n == N && m == M) || (n == M && m == N)){
                    System.out.println(ans);
                    return ;
                }
                if(n == N || n == M) queue.addLast(n);
                else if(m == N || m == M) queue.addLast(m);
                else queue.addLast(n);
            }
            if(win != 0) queue.offerLast(win);
            ans++;
        }
        System.out.println(ans);
    }
}