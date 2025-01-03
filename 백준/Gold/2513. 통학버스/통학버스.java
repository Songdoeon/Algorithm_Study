import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class School{
    int pos, count;

    public School(int pos, int count) {
        this.pos = pos;
        this.count = count;
    }
}

public class Main {
    static int N, K, S;
    static int getDis(int pos){
        return Math.abs(2 * (S - pos));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        PriorityQueue<School> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.pos)));
        PriorityQueue<School> pq2 = new PriorityQueue<>(((o1, o2) -> o2.pos - o1.pos));
        int bus = 0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            School s = new School(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            if(s.pos < S){
                pq.add(s);
            }
            else pq2.add(s);
        }
        while (!pq.isEmpty()){
            School s = pq.poll();
            int dis = getDis(s.pos);
            while (bus < K){
                if(s.count < K - bus){
                    bus += s.count;
                    s.count = 0;
                    if(pq.isEmpty())break;
                    s = pq.poll();
                }
                else{
                    s.count -=  K - bus;
                    bus = K;
                }
            }
            if(s.count != 0) pq.add(s);
            ans += dis;
            bus = 0;
        }
        bus = 0;
        while (!pq2.isEmpty()){
            School s = pq2.poll();
            int dis = getDis(s.pos);
            while (bus < K){
                if(s.count <= K - bus){
                    bus += s.count;
                    s.count = 0;
                    if(pq2.isEmpty())break;
                    s = pq2.poll();
                }
                else{
                    s.count -=  K - bus;
                    bus = K;
                }
            }
            if(s.count != 0) {
                pq2.add(s);
            }
            ans += dis;
            bus = 0;
        }
       System.out.println(ans);
    }
}