import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Deque<Character> stack;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            arr = br.readLine().toCharArray();
            int len = arr.length;
            if(len % 2 != 0) continue;
            stack = new ArrayDeque<>();
            for (int j = 0; j < len; j++) {
                char c = arr[j];
                if(c == 'A') {
                    if(stack.isEmpty() || stack.peek() != 'A') stack.push(c);
                    else stack.pop();
                }
                else if(c == 'B') {
                    if(stack.isEmpty() || stack.peek() != 'B') stack.push(c);
                    else stack.pop();
                }
            }
            if(stack.isEmpty())ans++;
        }
        System.out.println(ans);
    }
}