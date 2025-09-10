import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static Deque<int[]> stack = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()) {
                stack.push(new int[]{n, i});
                continue;
            }
            else if(stack.peek()[0] != n) {
                while(!stack.isEmpty() && stack.peek()[0] != n) {
                    int[] info = stack.pop();
                    arr[info[1]] = i;
                }
            }
            stack.push(new int[]{n, i});
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] info = stack.pop();
            arr[info[1]] = -1;
        }
        for (int i = 1; i <= N; i++) sb.append(arr[i]).append(' ');

        System.out.print(sb);
    }
}
