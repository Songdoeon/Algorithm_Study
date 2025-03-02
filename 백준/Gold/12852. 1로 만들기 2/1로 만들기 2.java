import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
    int num, cnt;

    public Pos(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}
public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[1_000_001];
        Queue<Pos> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cnt));
        queue.offer(new Pos(N, 0));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 1;
        if(N == 1){
            System.out.println(0 + "\n" + 1);
            return ;
        }
        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            if(cur.num == 1){
                stack.push(1);
                int n = arr[cur.num];
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
            if(cur.num / 3 >= 1 && cur.num % 3 == 0 && arr[cur.num / 3] == 0){
                queue.offer(new Pos(cur.num / 3, cur.cnt + 1));
                arr[cur.num / 3] = cur.num;
            }
            if(cur.num / 2 >= 1 && cur.num % 2 == 0 && arr[cur.num / 2] == 0){
                queue.offer(new Pos(cur.num / 2, cur.cnt + 1));
                arr[cur.num / 2] = cur.num;
            }
            if(cur.num >= 1 && arr[cur.num - 1] == 0){
                queue.offer(new Pos(cur.num - 1, cur.cnt + 1));
                arr[cur.num - 1] = cur.num;
            }
        }
        System.out.println(ans + "\n" + sb);
    }
}
