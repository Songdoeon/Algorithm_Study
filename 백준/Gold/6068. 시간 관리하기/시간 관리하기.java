import java.io.*;
import java.util.*;
class Work{
    int time, due;

    public Work(int time, int due) {
        this.time = time;
        this.due = due;
    }
}
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static final int INF = 1_000_001;
    public static void main(String[] args) throws Exception {
        Queue<Work> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.due));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            queue.offer(new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int time = 0;
        int s = INF;
        while (!queue.isEmpty()) {
            Work work = queue.poll();
            time += work.time;
            s = Math.min(s, work.due - time);
            if(time > work.due){
                System.out.println(-1);
                return ;
            }
        }
        System.out.println(s);
    }
}