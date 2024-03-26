import java.util.*;
import java.io.*;


class Main{
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder print = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder(br.readLine());

            if(!sb.toString().equals("READ")){
                stack.push(sb.toString());
            }
            else if(!stack.isEmpty()) {
                print.append(stack.pop()).append('\n');
            }
        }
        System.out.println(print);

    }
}
