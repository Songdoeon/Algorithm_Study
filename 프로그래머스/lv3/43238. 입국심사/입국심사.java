import java.util.*;
class Solution {
    int[] times;
    int n;
    long answer = Long.MAX_VALUE;
    boolean isPassed(long time){
        long sum = 0;
        for(int i = 0; i < times.length; i++){
            sum += time / times[i];
        }
        if(sum >= n) return true;
        return false;
    }
    
    public long solution(int n, int[] times) {
        this.times = times;
        this.n = n;
        long low = 0;
        long high = (long) n * times[times.length-1];
        
        while(low < high){
            long mid = (high + low) / 2;
            if(isPassed(mid)){
                answer = Math.min(answer,mid);
                high = mid;
            }
            else low = mid+1;
        }
        return answer;
    }
}