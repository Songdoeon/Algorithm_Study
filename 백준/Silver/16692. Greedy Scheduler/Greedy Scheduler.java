import java.util.*;
import java.io.*;


class Cashier{
    int no;
    PriorityQueue<Integer> queue;

    public Cashier(int no) {
        this.no = no;
        queue = new PriorityQueue<>();
    }
}
class Main{
    static int N, K;
    static PriorityQueue<Cashier> list = new PriorityQueue<>((o1, o2) -> {
        if(!o1.queue.isEmpty()){
            if(!o2.queue.isEmpty()){
                if(Objects.equals(o1.queue.peek(), o2.queue.peek())){
                    return o1.no - o2.no;
                }
                else return o1.queue.peek() - o2.queue.peek();
            }

            return 1;
        }
        if (!o2.queue.isEmpty()) {
            return -1;
        }
        return o1.no - o2.no;
    });
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            list.add(new Cashier(i));
        }
        st = new StringTokenizer(br.readLine());

        int time = 0;
        for (int i = 0; i < K; i++) {
            // 시간
            int n = Integer.parseInt(st.nextToken());

            // 가장 빨리 끝날 계산대
            Cashier c = list.poll();
            sb.append(c.no).append(' ');

            // 계산대 줄에 넣기
            c.queue.offer(time + n);

            // 큐에 다시 넣기
            list.offer(c);


//          전체 큐를 순회하며 현재 시간보다 적은 큐들을 비워준다.
            for (int j = 0; j < N; j++) {
                Cashier cashier = list.poll();
                while (!cashier.queue.isEmpty()){
                    if(cashier.queue.peek() > time) break;
                    cashier.queue.poll();
                }
                list.offer(cashier);
            }

            // 다음 가장 빨리 끝날 계산대에서 다음 설정할 시간을 구한다.
            if(!list.peek().queue.isEmpty()){
                if(time < list.peek().queue.peek())
                    time = list.peek().queue.peek();
            }
        }
        System.out.println(sb);
    }
}
