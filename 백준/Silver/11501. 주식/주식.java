import java.util.*;
import java.io.*;

class Main {
    static int T, N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        Deque<Integer> stack;
        while (T-- > 0){
            N = Integer.parseInt(br.readLine());
            stack = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            long sum = 0;
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                stack.push(n);
            }
            while (!stack.isEmpty()){
                int n = stack.pop();
                while (!stack.isEmpty() && stack.peek() < n) sum += n - stack.pop();
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}