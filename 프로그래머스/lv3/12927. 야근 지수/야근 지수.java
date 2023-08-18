import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 1;
        long sum = 0;
        int len = works.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work : works){
            queue.add(work);
        }
        
        for(int idx = 0;idx < n;idx++){
            while(queue.isEmpty()) return 0;
            int work = queue.remove();
            work--;
            if(work != 0) queue.add(work);
        }
        
        while(!queue.isEmpty()){
            long work = queue.remove();
            sum += work*work;
        }
        return sum;
    }
}