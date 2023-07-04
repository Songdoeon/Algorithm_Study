import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count = 0;
        
        for(int i : scoville){
            queue.add(i);
        }
        while(queue.peek()<K){
            try{
                queue.add(queue.poll()+queue.poll()*2);    
            }catch(Exception e){
                return -1;
            }
            
            count++;
        }
        return count;
    }
}