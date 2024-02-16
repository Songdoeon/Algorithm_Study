import java.util.*;
import java.io.*;

class Jewel{
    int weight;
    int price;

    public Jewel(int w, int p){
        this.weight = w;
        this.price = p;
    }

}
class Main{
    static PriorityQueue<Integer> jewelQueue = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Jewel> jewelList = new PriorityQueue<>((o1, o2) -> o1.weight == o2.weight ? o2.price - o1.price : o1.weight - o2.weight);

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arg = br.readLine().split(" ");
        int N = Integer.parseInt(arg[0]);
        int K = Integer.parseInt(arg[1]);
        long answer = 0;
        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewelList.offer(new Jewel(weight, price));
        }
        int[] backArr = new int[K];
        for(int i = 0; i < K; i++){
            backArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(backArr);

        for(int i = 0; i < K; i++){
            while(!jewelList.isEmpty() && jewelList.peek().weight <= backArr[i]){
                Jewel jewel = jewelList.poll();
                jewelQueue.add(jewel.price);
            }
            if(!jewelQueue.isEmpty()) answer += jewelQueue.poll();
        }
        System.out.println(answer);
    }
}