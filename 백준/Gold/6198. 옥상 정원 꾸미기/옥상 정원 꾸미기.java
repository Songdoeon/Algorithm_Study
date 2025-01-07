import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        long ans = 0;

        Deque<Integer> stack =  new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && n >= stack.peek()) {
                stack.pop();
            }
            ans += stack.size();
            stack.push(n);
        }
        System.out.println(ans);
    }
}