import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println(br.readLine());
            return ;
        }
        Queue<Integer> sQ = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> bQ = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        if(n1 > n2){
            bQ.add(n1);
            sQ.add(n2);
        }
        else{
            sQ.add(n1);
            bQ.add(n2);
        }
        int num = sQ.peek();
        sb.append(n1).append('\n');
        sb.append(num).append('\n');
        for (int i = 3; i <= N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n <= sQ.peek()){
                sQ.offer(n);
            }
            else {
                bQ.offer(n);
            }
            int s1 = sQ.size();
            int s2 = bQ.size();
            if(s1 == s2)sb.append(sQ.peek());
            else {
                if(s1 >= s2 + 2){
                    bQ.offer(sQ.poll());
                    sb.append(sQ.peek());
                }
                else if(s1 + 2 <= s2){
                    sQ.offer(bQ.poll());
                    sb.append(sQ.peek());
                }
                else if(s2 - s1 == 1){
                    sb.append(bQ.peek());
                }
                else{
                    sb.append(sQ.peek());
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
