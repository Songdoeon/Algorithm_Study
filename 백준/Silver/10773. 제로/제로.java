import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        int num;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            if(num == 0) {
                stack.pop();
            }else {
                stack.push(num);
            }
        }
        for (int i : stack) {
            sum += i;
        }
        System.out.println(sum);
    }
}