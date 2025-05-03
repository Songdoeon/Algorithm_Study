import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.StringTokenizer;

// 1863 - 10:55 시작

public class Main {
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek() > high){
                stack.pop();
                ans++;
            }
            
            if(high > 0 && (stack.isEmpty() || stack.peek() < high)){
                stack.push(high);
            }
        }
        ans += stack.size();
        System.out.println(ans);
    }
}

