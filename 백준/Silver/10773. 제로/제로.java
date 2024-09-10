import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        double sum = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(!stack.isEmpty() && n == 0) sum -= stack.pop();
            else {
                stack.push(n);
                sum += n;
            }
        }
        System.out.println((int) sum);
    }
}