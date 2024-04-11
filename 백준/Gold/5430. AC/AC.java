import java.util.*;
import java.io.*;

class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Deque<String> deque ;
        for (int i = 0; i < N; i++) {
            boolean left = true;
            String exec = br.readLine();
            boolean error = false;
            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();
            if(str.length() == 2 && exec.replaceAll("[R]","").length() > 0){
                sb.append("error").append('\n');
                continue;
            }
            deque = new ArrayDeque<>(List.of(str.substring(1, str.length() - 1).split(",")));
            int execLen = exec.length();

            for (int j = 0; j < execLen; j++) {
                if(exec.charAt(j) == 'R') left = !left;
                else {
                    if(deque.isEmpty()) {
                        sb.append("error").append('\n');
                        error = true;
                        break;
                    }
                    else if(left) deque.pollFirst();
                    else deque.pollLast();
                }
            }
            if(error)continue;
            if(deque.isEmpty()) {
                sb.append("[]").append('\n');
                continue;
            }
            sb.append('[');
            while (!deque.isEmpty()){
                if(left){
                    sb.append(deque.pollFirst()).append(',');
                }
                else sb.append(deque.pollLast()).append(',');
            }
            sb = new StringBuilder(sb.substring(0, sb.length() - 1));
            sb.append(']').append('\n');
        }
        System.out.println(sb);
    }
}