import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer=0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i : priorities){
            priorityQueue.add(i);
        }
        
        while(!priorityQueue.isEmpty()){
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == priorityQueue.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }   
                    priorityQueue.poll();
                    answer++;
                }
            }
        }
        return answer;
    }
}