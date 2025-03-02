import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[1_000_001];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 1;
        if(N == 1){
            System.out.println(0 + "\n" + 1);
            return ;
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == 1){
                stack.push(1);
                int n = arr[cur];
                while (n != N){
                    stack.push(n);
                    n = arr[n];
                    ans++;
                }
                stack.push(N);
                while(!stack.isEmpty()){
                    sb.append(stack.pop()).append(' ');
                }
                break;
            }
            if(cur % 3 == 0 && arr[cur / 3] == 0){
                queue.offer(cur / 3);
                arr[cur / 3] = cur;
            }
            if(cur % 2 == 0 && arr[cur / 2] == 0){
                queue.offer(cur / 2);
                arr[cur / 2] = cur;
            }
            if(arr[cur - 1] == 0){
                queue.offer(cur - 1);
                arr[cur - 1] = cur;
            }
        }
        System.out.println(ans + "\n" + sb);
    }
}
