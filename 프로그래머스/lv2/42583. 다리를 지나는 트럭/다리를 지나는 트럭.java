import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int lift = 0;
        int answer = 0;
        int index = 0;
        for(int i=0;i<bridge_length;i++){
            queue.add(0);
        }
        while(index < truck_weights.length){
            lift -= queue.poll();
            answer++;

            if(weight >= lift + truck_weights[index]){
                queue.offer(truck_weights[index]);
                System.out.println(lift);
                lift += truck_weights[index++];
            } else{
                queue.offer(0);
            }
        }
        return answer + bridge_length;
    }
}