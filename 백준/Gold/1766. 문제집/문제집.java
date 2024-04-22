import java.io.*;
import java.util.*;
class Main{
    static int N, M;
    static List<Integer>[] list;
    static int[] linked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new PriorityQueue<>();
        linked = new int[N + 1];
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2);
            linked[n2]++;
        }

        for (int i = 1; i <= N; i++) {
            if(linked[i] == 0)queue.offer(i);
        }

        while (!queue.isEmpty()){
            int n = queue.poll();
            sb.append(n).append(' ');
            int size = list[n].size();
            for (int i = 0; i < size; i++) {
                int next = list[n].get(i);
                if(--linked[next] == 0) queue.offer(next);
            }
        }
        System.out.println(sb);
    }
}