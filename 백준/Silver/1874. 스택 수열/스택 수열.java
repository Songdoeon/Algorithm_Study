import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int T;
    static StringBuilder sb = new StringBuilder();
    static int temp = 1;
    static boolean err = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0 ; i < T ; i++) {
            int N = Integer.parseInt(br.readLine());
            for( ; temp <= N ; temp++) {
                stack.push(temp);
                sb.append("+").append("\n");
            }
            if(stack.peek() == N) {
                stack.pop();
                sb.append("-").append("\n");
            }else {
                System.out.println("NO");
                return ;
            }
        }
        System.out.println(sb);
    }
}