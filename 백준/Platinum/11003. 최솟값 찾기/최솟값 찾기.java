import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 11003 : 17:25 시작

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while(!queue.isEmpty() && arr[i] < arr[queue.peekLast()]){
                queue.pollLast();
            }
            
            queue.offerLast(i);

            if(queue.peekFirst() <= i - M){
                queue.pollFirst();
            }

            sb.append(arr[queue.peekFirst()]).append(' ');
        }

        System.out.println(sb);
    }
}

