import java.io.*;
import java.util.*;

class Node{
    int idx, no, cnt;

    public Node(int idx, int no, int cnt) {
        this.idx = idx;
        this.no = no;
        this.cnt = cnt;
    }
//    @Override
//    public String toString() {
//        return
//                "{idx=" + idx +
//                ", cnt=" + cnt + "}";
//    }
}
public class Main{
    static int N;
    static int[] arr;
    static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = new int[N];
        int[] cnt = new int[100_000_001];
        Deque<Node> stack = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i]]++;
        }
        Arrays.fill(result, -1);
        for (int i = 0; i < N; i++) {
            Node n = new Node(i, arr[i], cnt[arr[i]]);
            while (!stack.isEmpty() && stack.peek().cnt < n.cnt){
                Node pre = stack.pop();
                result[pre.idx] = n.no;
            }
            stack.push(n);
        }

        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb);
    }
}