import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Pos{
    int idx, num;

    public Pos(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }
}
public class Main {
    static int N;
    static int[] arr;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = ans = new int[N];
        st = new StringTokenizer(br.readLine());
        Deque<Pos> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int n = arr[i];
            while (!stack.isEmpty()){
                if(stack.peek().num < n){
                    Pos p = stack.pop();
                    ans[p.idx] = n;
                }
                else break;
            }
            stack.push(new Pos(i, arr[i]));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            Pos p = stack.pop();
            ans[p.idx] = -1;
        }
        for (int an : ans) {
            sb.append(an).append(' ');
        }
        System.out.println(sb);
    }
}
